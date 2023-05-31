package Dao;
import DBHelper.SQLHelper;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Model.Homework;
public class HomeworkDao {
    public List<Homework> queryAllHomework(){
    	 List<Homework> clist=new ArrayList<Homework>();
    	 String sql="select * from homework";
    	 List<Object[]> cusarr=SQLHelper.executeQueryList(sql);
    	 for(Object[] arr:cusarr) {
    		 Homework c=new Homework();
    		 c.setHomeworkid(arr[0].toString());
    		 c.setName(arr[1].toString());
    		 c.setContent(arr[2].toString());
    		 c.setHome_endtime((LocalDateTime) arr[3]);
    		 c.setCourseid(arr[4].toString());
    		
    		 clist.add(c);
    	 }
    	 return clist;
    }
    public List<Homework> queryByCourseid(String courseid){
   	 List<Homework> clist=new ArrayList<Homework>();
   	 String sql="select * from homework where courseid='"+courseid+"'";
   	 List<Object[]> cusarr=SQLHelper.executeQueryList(sql);
   	 for(Object[] arr:cusarr) {
   		 Homework c=new Homework();
   		 c.setHomeworkid(arr[0].toString());
   		 c.setName(arr[1].toString());
   		 c.setContent(arr[2].toString());
   		c.setHome_endtime((LocalDateTime) arr[3]);
   		 c.setCourseid(arr[4].toString());
   		
   		 clist.add(c);
   	 }
   	 return clist;
   }

    public int deleteHomeworkByID(String id) {
    	String sql="delete from homework where homeworkid=?";
    	return SQLHelper.executeUpdateByParams(sql, id);
    }
    public int updateHomework(Homework st) {
    	String sql="update homework homeworkid=?,name=?,content?,home_endtime=? where homeworkid=?";
    	return SQLHelper.executeUpdateByParams(sql, st.getHomeworkid(),st.getName(),st.getContent(),st.getHome_endtime());
    }
    public int addHomework(Homework st) {
    	int r=0;
    	String sql="INSERT INTO `mydb`.`homework`"
    			+ "(`homeworkid`,"
    			+ "`name`,"
    			+ "`content`,"
    			+ "`home_endtime`,"
    			+ "`courseid`) values(?,?,?,?,?)";
    	r=SQLHelper.executeUpdateByParams(sql,st.getHomeworkid(),st.getName(),st.getContent(),st.getHome_endtime(),st.getCourseid());
    	return r;
    }
    public Homework queryHomeworkByID(String id) {
    	Homework cus=null;
    	String sql="select * from Homework where Homeworkid='"+id+"'";
    	List<Object[]> clist=SQLHelper.executeQueryList(sql);
    	if(clist!=null && clist.size()>0) {
    		cus=new Homework();
    		cus.setHomeworkid(clist.get(0)[0].toString());
    		cus.setName(clist.get(0)[1].toString());
    		cus.setContent(clist.get(0)[2].toString());
    		cus.setHome_endtime((LocalDateTime) clist.get(0)[3]);
    		cus.setCourseid(clist.get(0)[4].toString());
    	}
    	return cus;
    }
    
}
