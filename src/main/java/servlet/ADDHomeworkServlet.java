package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
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
import Dao.*;
import Model.*;


@WebServlet("/AddHomeworkServlet")
public class ADDHomeworkServlet extends HttpServlet {
    private TeacherDao tDao=new TeacherDao();
    private StudentDao sDao=new StudentDao();
    private HomeworkDao hDao=new HomeworkDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");     //解决乱码问
		String homeworkid= request.getParameter("homeworkid");
		String homeworkname= request.getParameter("object");
		String homecontent=request.getParameter("content");
		//1.具有转换功能的对象
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//2.要转换的对象	
		LocalDateTime time = LocalDateTime.now();
		String strLocalTime=request.getParameter("limittime");

		//3.LocalDate发动，将字符串转换成  df格式的LocalDateTime对象，的功能
		LocalDateTime LocalTime = LocalDateTime.parse(strLocalTime,df);

        
		String courseid= request.getParameter("courseid");
		
		if(homeworkid.equals("0")) {
			Homework hw= new Homework();
	   HomeworkDao hw1=new HomeworkDao();
		hw=hDao.queryHomeworkByID(homeworkid);
		if(hw==null) {
			
			hw.setHomeworkid(homeworkid);
			hw.setName(homeworkname);
			hw.setContent(homecontent);
			hw.setHome_endtime(LocalTime);
			hw.setCourseid(courseid);
			hDao.addHomework(hw);
			request.setAttribute("homeworkmsg", "添加成功，请去查看");
			request.getRequestDispatcher("addhomework.jsp").forward(request, response);
		}
		else {
			request.setAttribute("homeworkmsg", "作业id不能重复");
			request.getRequestDispatcher("addhomework.jsp").forward(request, response);
		
		}
		
		}
		
		
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	
	}

}
