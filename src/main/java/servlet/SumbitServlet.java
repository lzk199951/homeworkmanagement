package servlet;

import java.io.*;
import java.time.LocalDateTime;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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

		String Content = (String) request.getParameter("homeworkcontent");
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
		} else if(st.getStatus()=="已交"){
			LocalDateTime dateTime = LocalDateTime.now();
			st.setContent(Content);
			st.setSubmittime(dateTime);
			sh.updateStudentHomework(st);
			request.getRequestDispatcher("QueryHomeworkContentServlet?login=0").forward(request, response);
		}else {
		
			request.setAttribute("sumbitmsg", "已经批改不能重新提交");
			request.getRequestDispatcher("QueryHomeworkContentServlet?login=0").forward(request, response);
		}

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		try {
			SmartUpload su = new SmartUpload();
			// 上传初始化
			su.initialize(config, request, response);

			// 上传文件
			su.upload();
			// 读取当前网站实际物理路径
			String rootpath = config.getServletContext().getRealPath("/");
			String uname = su.getRequest().getParameter("uname");
			/* 根据用户名创建一个目录专门保存用户的图片 */
			java.io.File f = new java.io.File(rootpath + uname);
			System.out.print(rootpath + uname);
			if (!f.exists())
				f.mkdir();
			// 将上传文件全部保存到指定目录
			int count = su.save(f.getAbsolutePath());
			// 逐一提取上传文件信息，同时可保存文件。
			System.out.println("文件数" + su.getFiles().getCount());
			for (int i = 0; i < su.getFiles().getCount(); i++) {
				com.jspsmart.upload.File file = su.getFiles().getFile(i);
				// 若文件不存在则继续
				if (file.isMissing())
					continue;
				file.saveAs(f.getAbsolutePath() + "/" + file.getFileName(), su.SAVE_PHYSICAL);
			}
			out.print("用户图片保存成功");
		} catch (Exception ex) {
		}
	}
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	        doPost(request,response);
	    }
}
