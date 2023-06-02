package Dao;

import DBHelper.SQLHelper;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.ClassInfo;

public class ClassInfoDao {
	public List<ClassInfo> queryAllClassInfo() {
		List<ClassInfo> clist = new ArrayList<ClassInfo>();
		String sql = "select * from class";
		List<Object[]> cusarr = SQLHelper.executeQueryList(sql);
		for (Object[] arr : cusarr) {
			ClassInfo c = new ClassInfo();
			c.setClassid(arr[0].toString());
			c.setClassname(arr[1].toString());
			
			c.setTeacherid(arr[2].toString());
			clist.add(c);
		}
		return clist;
	}

	public int deleteClassInfoByID(String id) {
		String sql = "delete from class where classid=?";
		return SQLHelper.executeUpdateByParams(sql, id);
	}

//	public int updateClassInfo(ClassInfo cs) {
//		String sql = "update ClassInfo set cname=?,starttime=?,endtime=? where ClassInfoid=?";
//		return SQLHelper.executeUpdateByParams(sql, cs.getCname(), cs.getStarttime(), cs.getEndtime());
//	}

	public int addClassInfo(ClassInfo cs) {
		int r = 0;
		String sql = "INSERT INTO `mydb`.`class`"
				+ "(`classid`,"
				+ "`classname`,"
				+ "`teacherid`) values(?,?,?)";
		r = SQLHelper.executeUpdateByParams(sql, cs.getClassid(),cs.getClassname(),cs.getTeacherid());
		return r;
	}

	public ClassInfo queryClassInfoByID(String id) {
		ClassInfo cus = null;
		String sql = "select * from class where classid='" + id + "'";
		List<Object[]> clist = SQLHelper.executeQueryList(sql);
		if (clist != null && clist.size() > 0) {
			cus = new ClassInfo();
			cus.setClassid(clist.get(0)[0].toString());
			cus.setClassname(clist.get(0)[1].toString());
			cus.setTeacherid(clist.get(0)[2].toString());

		}
		return cus;
		
	}

	
	
	public ClassInfo queryClassInfoByTeacherID(String id) {
		ClassInfo cus = null;
		String sql = "select * from class where classid='" + id + "'";
		List<Object[]> clist = SQLHelper.executeQueryList(sql);
		if (clist != null && clist.size() > 0) {
			cus = new ClassInfo();
			cus.setClassid(clist.get(0)[0].toString());
			cus.setClassname(clist.get(0)[1].toString());
			cus.setTeacherid(clist.get(0)[2].toString());

		}
		return cus;
		
	}
	
	
	public List<ClassInfo> queryClassInfoByteacherid(String id ) {
		List<ClassInfo> clist = new ArrayList<ClassInfo>();
		String teacherid=id;
		String sql = "select * from class where teacherid="+"'"+teacherid+"'";
		List<Object[]> cusarr = SQLHelper.executeQueryList(sql);
		for (Object[] arr : cusarr) {
			ClassInfo c = new ClassInfo();
			c.setClassid(arr[0].toString());
			c.setClassname(arr[1].toString());
			
			c.setTeacherid(arr[2].toString());
			clist.add(c);
		}
		return clist;
	}
}
