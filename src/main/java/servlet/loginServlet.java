package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.TeacherDao;
import Dao.StudentDao;
import Model.Teacher;
import Model.Student;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private TeacherDao tDao=new TeacherDao();
    private StudentDao sDao=new StudentDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");     //解决乱码问题
		String user_id = request.getParameter("user_id");
		String pwd = request.getParameter("pwd");
		String login = request.getParameter("login");
		if(login.equals("0")) {
		Teacher tus=new Teacher();
		tus=tDao.queryTeacherByID(user_id);
		if(tus==null) {
			request.setAttribute("loginmsg", "没有此老师");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		if(pwd.equals(tus.getPassword())) {
			String teacherid=user_id;
			request.setAttribute("teacherid",teacherid);
			request.getRequestDispatcher("Teacher.jsp").forward(request, response);
		}else {
			request.setAttribute("loginmsg", "密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		
		}
		}
		if(login.equals("1")) {
			Student sus=new Student();
			sus=sDao.queryStudentByID(user_id);
			if(pwd.equals(sus.getPassword())) {
				request.setAttribute("user_id",user_id);
				request.getRequestDispatcher("/QueryHomeworkServlet").forward(request,response);
			
			}else {
				response.sendRedirect("login.jsp");
			}
		}
		if(login.equals("2")) {
			if(user_id.equals("lizekun")&&pwd.equals("123456")) {
				
				response.sendRedirect("Admin.jsp");
			}
			else {
				request.setAttribute("loginmsg", "密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
		
		 this.getServletContext().setAttribute("data",user_id);  //将user_id传递给editQueServlet
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	
	}

}
