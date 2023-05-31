package Dao;
import DBHelper.SQLHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.Student;
public class StudentDao {
    public List<Student> queryAllstudent(){
    	 List<Student> clist=new ArrayList<Student>();
    	 String sql="select * from student";
    	 List<Object[]> cusarr=SQLHelper.executeQueryList(sql);
    	 for(Object[] arr:cusarr) {
    		 Student c=new Student();
    		 c.setStuentid(arr[0].toString());
    		 c.setName(arr[1].toString());
    		 c.setPassword(arr[2].toString());
    		 c.setSex(arr[3].toString());
    		 c.setBirth(arr[4].toString());
    		
    		 c.setNation(arr[5].toString());
    		 c.setStatus(arr[6].toString()); 
    		 c.setAddress(arr[7].toString());
    		 c.setClassid(arr[8].toString());
    		 clist.add(c);
    	 }
    	 return clist;
    }

    public int deleteStudentByID(String id) {
    	String sql="delete from student where studentid=?";
    	return SQLHelper.executeUpdateByParams(sql, id);
    }
    public int updateStudent(Student st) {
    	String sql="update student set name=?,password=?,sex=?,birth=?,address=?,nation=?,status=? where studentid=?";
    	return SQLHelper.executeUpdateByParams(sql, st.getName(),st.getPassword(),st.getSex(),st.getBirth(),st.getAddress(),st.getNation(),st.getStatus());
    }
    public int addStudent(Student st) {
    	int r=0;
    	String sql="insert into student (`studentid`,"
    			+ "`name`,"
    			+ "`password`,"
    			+ "`sex`,"
    			+ "`birth`,"
    			+ "`nation`,"
    			+ "`status`,"
    			+ "`address`,"
    			+ "`classid`) values(?,?,?,?,?,?,?,?)";
    	r=SQLHelper.executeUpdateByParams(sql,st.getStuentid(),st.getName(),
    			st.getPassword(),st.getSex(),st.getBirth(),st.getNation(),st.getStatus(),st.getAddress(),st.getClassid());
    	return r;
    }
    public Student queryStudentByID(String id) {
    	Student cus=null;
    	String sql="select * from student where studentid='"+id+"'";
    	List<Object[]> clist=SQLHelper.executeQueryList(sql);
    	if(clist!=null && clist.size()>0) {
    		cus=new Student();
    		cus.setStuentid(clist.get(0)[0].toString());
    		cus.setName(clist.get(0)[1].toString());
    		cus.setPassword(clist.get(0)[2].toString());
    		 cus.setSex(clist.get(0)[3].toString());
    		 cus.setBirth(clist.get(0)[4].toString());
    		 cus.setNation(clist.get(0)[5].toString());
    		 cus.setStatus(clist.get(0)[6].toString());
    		 cus.setAddress(clist.get(0)[7].toString());
    		 cus.setClassid(clist.get(0)[8].toString());
    	}
    	return cus;
    }
    public List<Student> queryByClassid(String id){
   	 List<Student> clist=new ArrayList<Student>();
   	 String sql="select * from student where classid='"+id+"'";
   	 List<Object[]> cusarr=SQLHelper.executeQueryList(sql);
   	 for(Object[] arr:cusarr) {
   		 Student c=new Student();
   		 c.setStuentid(arr[0].toString());
   		 c.setName(arr[1].toString());
   		 c.setPassword(arr[2].toString());
   		 c.setSex(arr[3].toString());
   		 c.setBirth(arr[4].toString());
   		
   		 c.setNation(arr[5].toString());
   		 c.setStatus(arr[6].toString()); 
   		 c.setAddress(arr[7].toString());
   		 c.setClassid(arr[8].toString());
   		 clist.add(c);
   	 }
   	 return clist;
   }
}
