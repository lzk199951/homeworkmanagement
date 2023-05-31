package Dao;
import DBHelper.SQLHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.Teacher;
public class TeacherDao {
    public List<Teacher> queryAllteacher(){
    	 List<Teacher> clist=new ArrayList<Teacher>();
    	 String sql="select * from teacher";
    	 List<Object[]> cusarr=SQLHelper.executeQueryList(sql);
    	 for(Object[] arr:cusarr) {
    		 Teacher c=new Teacher();
    		 c.setTeacherid(arr[0].toString());
    		 c.setName(arr[1].toString());
    		 c.setPassword(arr[2].toString());
    		 c.setSex(arr[3].toString());
    		 c.setStatus(arr[4].toString());
    		 clist.add(c);
    	 }
    	 return clist;
    }

    public int deleteTeacherByID(String id) {
    	String sql="delete from teacher where teacherid=?";
    	return SQLHelper.executeUpdateByParams(sql, id);
    }
    public int updateTeacher(Teacher tc) {
    	String sql="update teacher set name=?,sex=?,status=? where teacherid=?";
    	return SQLHelper.executeUpdateByParams(sql,tc.getName(),tc.getSex(),tc.getStatus(),tc.getTeacherid());
    }
    public int addTeacher(Teacher tc) {
    	int r=0;
    	
    	String sql="insert into teacher values(?,?,?,?,?)";
    	r=SQLHelper.executeUpdateByParams(sql,tc.getTeacherid(),tc.getName(),tc.getPassword(),tc.getSex(),tc.getStatus());
    	return r;
    }
    public Teacher queryTeacherByID(String id) {
    	Teacher cus=null;
    	String sql="select * from teacher where teacherid='"+id+"'";
    	List<Object[]> clist=SQLHelper.executeQueryList(sql);
    	if(clist!=null && clist.size()>0) {
    		cus=new Teacher();
    		cus.setTeacherid(clist.get(0)[0].toString());
    		cus.setName(clist.get(0)[1].toString());
    		cus.setPassword(clist.get(0)[2].toString());
    		cus.setSex(clist.get(0)[3].toString());
    		cus.setStatus(clist.get(0)[4].toString());
    	}
    	return cus;
    }
}
