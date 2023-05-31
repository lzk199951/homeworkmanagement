package Dao;

import DBHelper.SQLHelper;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import Model.Course;

public class CourseDao {
	public List<Course> queryAllcourse() {
		List<Course> clist = new ArrayList<Course>();
		String sql = "select * from course";
		List<Object[]> cusarr = SQLHelper.executeQueryList(sql);
		for (Object[] arr : cusarr) {
			Course c = new Course();
			c.setCourseid(arr[0].toString());
			c.setCname(arr[1].toString());
			c.setStarttime((LocalDateTime) arr[2]);
			c.setEndtime((LocalDateTime) arr[3]);
			c.setTeacherid(arr[4].toString());
			c.setClassid(arr[5].toString());
			clist.add(c);
		}
		return clist;
	}

	public int deleteCourseByID(String id) {
		String sql = "delete from course where courseid=?";
		return SQLHelper.executeUpdateByParams(sql, id);
	}

	public int updateCourse(Course cs) {
		String sql = "update course set cname=?,starttime=?,endtime=? where courseid=?";
		return SQLHelper.executeUpdateByParams(sql, cs.getCname(), cs.getStarttime(), cs.getEndtime());
	}

	public int addCourse(Course cs) {
		int r = 0;
		String sql = "INSERT INTO `mydb`.`course`" + "(`courseid`," + "`cname`," + "`starttime`," + "`endtime`,"
				+ "`teacherid` ,"+"`cname` ) values(?,?,?,?,?,?)";
		r = SQLHelper.executeUpdateByParams(sql, cs.getCourseid(), cs.getCname(), cs.getStarttime(), cs.getEndtime(),
				cs.getTeacherid(),cs.getClassid());
		return r;
	}

	public Course queryCourseByID(String id) {
		Course cus = null;
		String sql = "select * from course where courseid='" + id + "'";
		List<Object[]> clist = SQLHelper.executeQueryList(sql);
		if (clist != null && clist.size() > 0) {
			cus = new Course();
			cus.setCourseid(clist.get(0)[0].toString());
			cus.setCname(clist.get(0)[1].toString());
			cus.setStarttime((LocalDateTime) clist.get(0)[2]);
			cus.setEndtime((LocalDateTime) clist.get(0)[3]);
			cus.setTeacherid(clist.get(0)[4].toString());
			cus.setClassid(clist.get(0)[5].toString());

		}
		return cus;
		
	}

	
	
	public List<Course>queryCourseByclassID(String id) {
		List<Course> clist = new ArrayList<Course>();
		String sql = "select * from course where  classid='" + id + "'";
		List<Object[]> cuarr = SQLHelper.executeQueryList(sql);
		for (Object[] arr : cuarr) {
			Course c = new Course();
			c.setCourseid(arr[0].toString());
			c.setCname(arr[1].toString());
			c.setStarttime((LocalDateTime) arr[2]);
			c.setEndtime((LocalDateTime) arr[3]);
			c.setTeacherid(arr[4].toString());
			c.setClassid(arr[5].toString());
			clist.add(c);
		}
		return clist;
		
	}

	public Course queryCourseByTeacherid(String id) {
		Course cus = null;
		String sql = "select * from course where teacherId='" + id + "'";
		List<Object[]> clist = SQLHelper.executeQueryList(sql);
		if (clist != null && clist.size() > 0) {
			cus = new Course();
			cus.setCourseid(clist.get(0)[0].toString());
			cus.setCname(clist.get(0)[1].toString());
			cus.setStarttime((LocalDateTime) clist.get(0)[2]);
			cus.setEndtime((LocalDateTime) clist.get(0)[3]);
			cus.setTeacherid(clist.get(0)[4].toString());
			cus.setClassid(clist.get(0)[5].toString());

		}
		return cus;
	}
}
