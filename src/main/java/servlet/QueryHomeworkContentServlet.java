package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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
import Model.StudentHomework;
import Dao.CourseDao;
import Model.Course;
import Model.Homework;
import Dao.*;

@WebServlet("/QueryHomeworkContentServlet")
public class QueryHomeworkContentServlet extends HttpServlet {
	private TeacherDao tDao = new TeacherDao();
	private StudentDao sDao = new StudentDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String login = request.getParameter("login");
		String user_id = (String) request.getSession().getAttribute("user_id");
		if (login.equals("0")) {
			StudentDao sDao = new StudentDao();

			Student sus = new Student();
			sus = sDao.queryStudentByID(user_id);
			String classid = sus.getClassid();
			CourseDao cd = new CourseDao();
			List<Course> cl = cd.queryCourseByclassID(classid);
			HomeworkDao hd = new HomeworkDao();
			List<Homework> h1 = new ArrayList();
			for (Course a : cl) {
				h1.addAll(hd.queryByCourseid(a.getCourseid()));
			}
			;
			StudentHomeworkDao s1 = new StudentHomeworkDao();
			HomeworkDao s2 = new HomeworkDao();
			List<StudentHomework> sh = new ArrayList();
			for (Homework a : h1) {
				sh.addAll(s1.queryStudentHomeworkBystudentidl(user_id, a.getHomeworkid()));
			}
			List<Homework> h2 = new ArrayList();
			for (Homework b : h1) {
				boolean isSubmit=false;
			 	for (StudentHomework a : sh) {
					if (a.getHomeworkid().equals(b.getHomeworkid())) {
						isSubmit=true;
					}
				}
				if(!isSubmit){
					h2.add(b);
				}
			}
			request.setAttribute("h2", h2);
			request.setAttribute("sh", sh);
			request.getRequestDispatcher("homeworkcontent.jsp").forward(request, response);
		}
		if (login.equals("2")) {

			response.sendRedirect("login.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
