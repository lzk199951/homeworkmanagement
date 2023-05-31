package Model;

import java.time.LocalDateTime;
import java.util.Date;

public class StudentHomework {
String studentid,homeworkid,content,status;
Double score;
LocalDateTime submittime;
public String getStudentid() {
	return studentid;
}
public void setStudentid(String studentid) {
	this.studentid = studentid;
}
public String getHomeworkid() {
	return homeworkid;
}
public void setHomeworkid(String homeworkid) {
	this.homeworkid = homeworkid;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Double getScore() {
	return score;
}
public void setScore(Double score) {
	this.score = score;
}
public LocalDateTime getSubmittime() {
	return submittime;
}
public void setSubmittime(LocalDateTime submittime) {
	this.submittime = submittime;
}

}
