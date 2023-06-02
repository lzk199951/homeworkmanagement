package Dao;
import DBHelper.SQLHelper;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Model.StudentHomework;
public class StudentHomeworkDao {
    public List<StudentHomework> queryAllStudentHomework(){
    	 List<StudentHomework> clist=new ArrayList<StudentHomework>();
    	 String sql="select * from student_homework";
    	 List<Object[]> cusarr=SQLHelper.executeQueryList(sql);
    	 for(Object[] arr:cusarr) {
    		 StudentHomework c=new StudentHomework();
    		 c.setStudentid(arr[0].toString());
    		 c.setHomeworkid(arr[1].toString());
    		 c.setSubmittime((LocalDateTime) arr[2]);
    		 c.setContent(arr[3].toString());
    		 c.setStatus(arr[4].toString());
    		 c.setScore((Double) arr[5]);
    		  c.setFilelocation(arr[6].toString());
    		 clist.add(c);
    	 }
    	 return clist;
    }

    public int updateStudentHomework(StudentHomework st) {
    	String sql="update student_homework set content=? where studentid=? and homeworkid=?";
    	return SQLHelper.executeUpdateByParams(sql, st.getContent(),st.getStudentid(),st.getHomeworkid());
    }
    public int updateStudentHomework_tc(StudentHomework st) {
    	String sql="update student_homework set status=?,score=? where studentid=? and homeworkid=?";
    	return SQLHelper.executeUpdateByParams(sql, st.getStatus(),st.getScore(),st.getStudentid(),st.getHomeworkid());
    }
    public int addStudentHomework(StudentHomework st) {
    	int r=0;
    	String sql="INSERT INTO `mydb`.`student_homework`\r\n"
    			+ "(`studentid`,\r\n"
    			+ "`homeworkid`,\r\n"
    			+ "`submittime`,\r\n"
    			+ "`content`,\r\n"
    			+ "`status`,\r\n"
    			+ "`score`,\r\n"
    			+ "`filelocation`) values(?,?,?,?,?,?,?)";
    	r=SQLHelper.executeUpdateByParams(sql,st.getStudentid(),st.getHomeworkid(),st.getSubmittime(),st.getContent(),st.getStatus(),st.getScore(),st.getFilelocation());
    	return r;
    }
    public List<StudentHomework> queryStudentHomeworkBystudentidl(String studentid,String homeworkid){
   	 List<StudentHomework> clist=new ArrayList<StudentHomework>();
   	 String sql="select * from student_homework where studentid="+"'"+studentid+"'"+"and homeworkid="+"'"+homeworkid+"'";
   	 List<Object[]> cusarr=SQLHelper.executeQueryList(sql);
   	 for(Object[] arr:cusarr) {
   		 StudentHomework c=new StudentHomework();
   		 c.setStudentid(arr[0].toString());
   		 c.setHomeworkid(arr[1].toString());
   		 c.setSubmittime((LocalDateTime) arr[2]);
   		 c.setContent(arr[3].toString());
   		 c.setStatus(arr[4].toString());
   		
   		 c.setScore((Double) arr[5]);
   		 c.setFilelocation(arr[6].toString());
   		 clist.add(c);
   	 }
   	 return clist;
   }
    public StudentHomework queryStudentHomeworkBystudentid(String studentid,String homeworkid) {
    	StudentHomework cus=null;
    	String sql="select * from student_homework where studentid="+"'"+studentid+"'"+"and homeworkid="+"'"+homeworkid+"'";
    	List<Object[]> clist=SQLHelper.executeQueryList(sql);
    	if(clist!=null && clist.size()>0) {
    		cus=new StudentHomework();
    		cus.setStudentid(clist.get(0)[0].toString());
    		cus.setHomeworkid(clist.get(0)[1].toString());
    		cus.setSubmittime((LocalDateTime) clist.get(0)[2]);
    		 cus.setContent(clist.get(0)[3].toString());
    		 cus.setStatus(clist.get(0)[4].toString());
    		 cus.setScore((Double) clist.get(0)[5]);
    		 cus.setFilelocation(clist.get(0)[6].toString());
    		 
    	}
    	return cus;
    }
    public StudentHomework queryStudentHomeworkBystudentid(String studentid) {
    	StudentHomework cus=null;
    	String sql="select * from student_homework where studentid="+"'"+studentid+"'";
    	List<Object[]> clist=SQLHelper.executeQueryList(sql);
    	if(clist!=null && clist.size()>0) {
    		cus=new StudentHomework();
    		cus.setStudentid(clist.get(0)[0].toString());
    		cus.setHomeworkid(clist.get(0)[1].toString());
    		cus.setSubmittime((LocalDateTime) clist.get(0)[2]);
    		 cus.setContent(clist.get(0)[3].toString());
    		 cus.setStatus(clist.get(0)[4].toString());
    		 cus.setScore((Double) clist.get(0)[5]);
    		 cus.setFilelocation(clist.get(0)[6].toString());
    		 
    	}
    	return cus;
    }
    public StudentHomework queryStudentHomeworkByclassid(String classid) {
    	StudentHomework cus=null;
    	String sql="select * from student_homework where classid=?";
    	List<Object[]> clist=SQLHelper.executeQueryList(sql,classid);
    	if(clist!=null && clist.size()>0) {
    		cus=new StudentHomework();
    		cus.setStudentid(clist.get(0)[0].toString());
    		cus.setHomeworkid(clist.get(0)[1].toString());
    		cus.setSubmittime((LocalDateTime) clist.get(0)[2]);
    		 cus.setContent(clist.get(0)[3].toString());
    		 cus.setStatus(clist.get(0)[4].toString());
    		 cus.setScore((Double) clist.get(0)[5]);
    		 cus.setFilelocation(clist.get(0)[6].toString());
    	}
    	return cus;
    }
    
    
}
