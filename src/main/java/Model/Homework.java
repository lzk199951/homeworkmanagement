package Model;

import java.time.LocalDateTime;
import java.util.Date;

public class Homework {
	 private String homeworkid,name,content,courseid;
	 LocalDateTime home_endtime;
	public String getHomeworkid() {
		return homeworkid;
	}

	public void setHomeworkid(String homeworkid) {
		this.homeworkid = homeworkid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	

	public LocalDateTime getHome_endtime() {
		return home_endtime;
	}

	public void setHome_endtime(LocalDateTime home_endtime) {
		this.home_endtime = home_endtime;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	
	
}
