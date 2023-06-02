package servlet;

import java.io.*;
import java.io.File;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jspsmart.upload.*;
import Dao.*;
import Model.*;

@WebServlet("/SumbitServlet")
public class SumbitServlet extends HttpServlet {
	private ServletConfig config;

	final public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_id = (String) request.getSession().getAttribute("user_id");
		String homework_id = (String) request.getParameter("homeworkid");
		// SetCharacterEncoding = UTF-8
		request.setCharacterEncoding("utf-8");
        
        // Judge multipart or not
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        Map<String,String> params = new HashMap<String,String>();
        String filePath=null;

        // Multipart form
        if (isMultipart)
        {
            // Create a factory for disk-based file items
            FileItemFactory factory = new DiskFileItemFactory();
 
            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            try
            {
                // Parse the request
                List<FileItem> items = upload.parseRequest(request);
 
                // Process the uploaded items
                Iterator<FileItem> iter = items.iterator();
 
                // Do list
                while (iter.hasNext())
                {
                    FileItem item = iter.next();
                    // Form Field
                    if (item.isFormField())
                    {
                        // Field name
                        String name = item.getFieldName();
                        // Set charset = UTF-8 Default = ISO-8859-1 
                        // Get field value
                        String value = item.getString("utf-8");
                        // Put into map
                        params.put(name, value.trim());
                        System.out.println("表单项的name："+item.getFieldName());
                        System.out.println("值为："+value);
                    }else{
                    	String folder="D:/Data/upload";
                        //String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
                         File file = new File(folder);
                         if (!file.exists()) {
                           file.mkdirs();                                                                  
                         }
                        item.write(new File(folder + "/" + item.getName()));
                    	 filePath=folder + "/" + item.getName();
                    	//上传的文件
                         System.out.println("表单项的name："+item.getFieldName());
                         System.out.println("上传的文件名为："+item.getName());
                         System.out.println("上传的文件名为："+filePath);
                    }
                }
            }
            catch (Exception fue)
            {
                fue.printStackTrace();
            }
        }
        

		String Content = params.get("homeworkcontent");
		StudentHomeworkDao sh = new StudentHomeworkDao();
		StudentHomework st = sh.queryStudentHomeworkBystudentid(user_id, homework_id);
		if (st == null) {
			st=new StudentHomework();
			LocalDateTime dateTime = LocalDateTime.now();
			st.setHomeworkid(homework_id);
			st.setContent(Content);
			st.setStudentid(user_id);
			st.setStatus("已交");
			st.setScore(0.0);
			st.setSubmittime(dateTime);
			sh.addStudentHomework(st);
			
			request.getRequestDispatcher("QueryHomeworkContentServlet?login=0").forward(request, response);
		} else if("已交".equals(st.getStatus())){
			LocalDateTime dateTime = LocalDateTime.now();
			st.setContent(Content);
			st.setSubmittime(dateTime);
			sh.updateStudentHomework(st);
			request.getRequestDispatcher("QueryHomeworkContentServlet?login=0").forward(request, response);
		}else {
		
			request.setAttribute("sumbitmsg", "已经批改不能重新提交");
			request.getRequestDispatcher("QueryHomeworkContentServlet?login=0").forward(request, response);
		}

	}
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	        doPost(request,response);
	    }
}
