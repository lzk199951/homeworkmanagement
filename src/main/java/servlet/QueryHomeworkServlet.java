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
import Dao.CourseDao;
import Model.Course;
import Model.Homework;
import Dao.*;

@WebServlet("/QueryHomeworkServlet")
public class QueryHomeworkServlet extends HttpServlet {
    private TeacherDao tDao=new TeacherDao();
    private StudentDao sDao=new StudentDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String user_id=(String) request.getAttribute("user_id");
		   StudentDao sDao=new StudentDao();
		   Student sus=new Student();
			sus=sDao.queryStudentByID(user_id);
			String classid=sus.getClassid();
			CourseDao cd=new CourseDao();
			 List<Course> cl= cd.queryCourseByclassID(classid);
			 HomeworkDao hd=new HomeworkDao(); 
			 List<Homework> h1=new ArrayList();
			 for(Course a:cl)
			 {
				 h1.addAll(hd.queryByCourseid(a.getCourseid()));
			 };
			 request.setAttribute("h1", h1);
			 request.setAttribute("user_id",user_id);
			request.getRequestDispatcher("homework.jsp").forward(request, response);
		     

	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	
	}

}
