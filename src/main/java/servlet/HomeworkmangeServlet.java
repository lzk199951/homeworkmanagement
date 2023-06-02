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
import Dao.*;
import Model.*;

@WebServlet("/HomeworkmangeServlet")
public class HomeworkmangeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 解决乱码问
		String teacherid = (String) request.getSession().getAttribute("teacherid");
		String homework = request.getParameter("homework");
		HomeworkDao sDao = new HomeworkDao();
		ClassInfoDao csDao = new ClassInfoDao();
		CourseDao cDao = new CourseDao();
		StudentDao ssDao = new StudentDao();
		StudentHomeworkDao stus = new StudentHomeworkDao();
		if (homework.equals("0")) {
			List<ClassInfo> ctu = new ArrayList();// 得到老师教的班级
			ctu = csDao.queryClassInfoByteacherid(teacherid);
			Homework stu = new Homework();
			List<Course> cr = new ArrayList();
			cr = (List<Course>) cDao.queryCourseByTeacherID(teacherid);// 得到老师教的课程
			List<Homework> hr = new ArrayList();
			for (Course a : cr) {
				hr.addAll(sDao.queryByCourseid(a.getCourseid()));// 获得布置的作业
			}
			List<StudentHomework> str = new ArrayList();

			List<Student> st = new ArrayList();
			List<Student> st1 = new ArrayList();
			st = ssDao.queryAllstudent();
			for (ClassInfo b : ctu) {
				 for (Student a : st){
					if (a.getClassid().equals(b.getClassid())) {
						st1.add(a);
					}

				}
			} // 得到老师教的学生st1
			List<Student> st2 = new ArrayList();
			for (Student c : st1) {
				str.addAll(stus.queryStudentHomeworkBystudentidlist(c.getStuentid()));
				if (stus.queryStudentHomeworkBystudentid(c.getStuentid()) == null) {
					st2.add(c);
				}
			}
			request.setAttribute("str", str); // 对应学生交的作业
			request.setAttribute("hr", hr); // 布置的作业
			request.setAttribute("st2", st2); // 未交作业的学生名单
			request.getRequestDispatcher("homeworkview.jsp").forward(request, response);
		}

	}

//		if(homework.equals("1")) {
//			String suid=request.getParameter("homeworkdeleteid");
//			homework stu=new homework();
//			stu=sDao.queryhomeworkByID(suid);
//			if(stu==null) 
//			{request.setAttribute("homeworkmsg", "无该学生");
//			request.getRequestDispatcher("homeworkmanger.jsp").forward(request, response);
//				}else {
//					sDao.deletehomeworkByID(suid);
//					request.setAttribute("homeworkmsg", "删除成功");
//					request.getRequestDispatcher("homeworkmanger.jsp").forward(request, response);
//				}
//			}
//		if(homework.equals("2"))
//		{
//			List<homework> allstu=new ArrayList();
//		   allstu=sDao.queryAllhomework();
//		   request.setAttribute("allstu", allstu);
//			request.getRequestDispatcher("allhomeworkinformation.jsp").forward(request, response);
//		}
//		
//		
//		
//}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
