package Model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Course {
	public String courseid,cname,teacherid,classid;
	LocalDateTime starttime,endtime;
public String getCourseid() {
	return courseid;
}
public void setCourseid(String courseid) {
	this.courseid = courseid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getTeacherid() {
	return teacherid;
}
public void setTeacherid(String teacherid) {
	this.teacherid = teacherid;
}
public String getClassid() {
	return classid;
}
public void setClassid(String classid) {
	this.classid = classid;
}
public LocalDateTime getStarttime() {
	return starttime;
}
public void setStarttime(LocalDateTime starttime) {
	this.starttime = starttime;
}
public LocalDateTime getEndtime() {
	return endtime;
}
public void setEndtime(LocalDateTime endtime) {
	this.endtime = endtime;
}


	

}
