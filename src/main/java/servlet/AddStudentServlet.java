package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.TeacherDao;
import Dao.StudentDao;
import Model.Teacher;
import Model.Student;


@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    private TeacherDao tDao=new TeacherDao();
    private StudentDao sDao=new StudentDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");     //解决乱码问
		String student= request.getParameter("student");
		String studentname= request.getParameter("studentname");
		String studentpassword= request.getParameter("studentpassword");
		String studentclass= request.getParameter("studentclass");
		
		if(student.equals("0")) {
	    String suid=request.getParameter("studentid");
		Student stu=new Student();
		stu=sDao.queryStudentByID(suid);
		if(stu==null) {
			Student stu1=new Student();
			stu1.setStuentid(suid);
			stu1.setName(studentname);
			stu1.setPassword(studentpassword);
			stu1.setClassid(studentclass);
			sDao.addStudent(stu1);
			request.setAttribute("studentmsg", "添加成功，请去登陆");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			request.setAttribute("studentmsg", "已有该学生");
			request.getRequestDispatcher("Studentmanger.jsp").forward(request, response);
		
		}
		
		}
		
		if(student.equals("1")) {
			String suid=request.getParameter("studentdeleteid");
			Student stu=new Student();
			stu=sDao.queryStudentByID(suid);
			if(stu==null) 
			{request.setAttribute("studentmsg", "无该学生");
			request.getRequestDispatcher("Studentmanger.jsp").forward(request, response);
				}else {
					sDao.deleteStudentByID(suid);
					request.setAttribute("studentmsg", "删除成功");
					request.getRequestDispatcher("Studentmanger.jsp").forward(request, response);
				}
			}
		if(student.equals("2"))
		{
			List<Student> allstu=new ArrayList();
		   allstu=sDao.queryAllstudent();
		   request.setAttribute("allstu", allstu);
			request.getRequestDispatcher("allstudentinformation.jsp").forward(request, response);
		}
		
		
		
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	
	}

}
