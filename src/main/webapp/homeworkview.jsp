<%@ page language="java"
	import="Dao.*,Model.*,java.time.LocalDateTime,java.util.List"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>欢迎您的使用</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

form button {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	background-color: #b0c4de;
	border: 1px solid black;
	border-radius: 5px;
	cursor: pointer;
}

body {
	background: url(./几何图片.jpg) no-repeat center 0px fixed;
	background-size: cover;
	font-family: "微软雅黑", sans-serif;
}

.login {
	position: absolute;
	top: 40%;
	left: 40%;
	margin: -150px 0 0 -150px;
	width: 900px;
	height: 300px;
}
</style>
<style type="texts">
			table.hovertable {
			    font-family: verdana,arial,sans-serif;
			    font-size:11px;
			    color:#333333;
			    border-width: 1px;
			    border-color: #999999;
			    border-collapse: collapse;
			}
			table.hovertable th {
			    background-color:#c3dde0;
			    border-width: 1px;
			    padding: 8px;
			    border-style: solid;
			    border-color: #a9c6c9;
			}
			table.hovertable tr {
			    background-color:#d4e3e5;
			}
			table.hovertable td {
			    border-width: 1px;
			    padding: 8px;
			    border-style: solid;
			    border-color: #a9c6c9;
			}
			</style>
<script type="text/javascript">
	function del() {
		var msg = "您真的确定要删除吗?请确认！";
		if (confirm(msg)) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>

	<div class="login">
		<table width="60%" border=1 class="hovertable">
			<thead>
				<tr>
					<th>作业id</th>
					<th>作业内容</th>
				</tr>

			</thead>
			<tbody>
				<%
				
				List<StudentHomework> a1 = (List<StudentHomework>) request.getAttribute("str");
				List<Homework> h2 = (List<Homework>) request.getAttribute("hr");
				List<Student> s1=(List<Student>)request.getAttribute("st2");
 				HomeworkDao a = new HomeworkDao();

				for (Homework h : h2) {

					out.println(
					"<tr onmouseover=\"this.style.backgroundColor='#ffff66';\" onmouseout=\"this.style.backgroundColor='#d4e3e5';\">");
					out.println("<td>" + h.getHomeworkid() + "</td>");
					out.println("<td>" + h.getContent() + "</td>");
					
				}	%>
<div class="login">
		<table width="60%" border=1 class="hovertable">
			<thead>
				<tr>
					<th>作业id</th>
					<th>作业内容</th>
					<th>作业状态</th>
					<th>得分</th>
					<th>sf</th>
				</tr>

			</thead>
			<tbody>
			<% 
				for (StudentHomework h : a1) {
					out.println(
					"<tr onmouseover=\"this.style.backgroundColor='#ffff66';\" onmouseout=\"this.style.backgroundColor='#d4e3e5';\">");
					out.println("<td>" + h.getHomeworkid() + "</td>");
					out.println("<td>" + h.getContent() + "</td>");
					out.println("<td>" + h.getStatus() + "</td>");
					out.println("<td>" + h.getScore() + "</td>");
					out.println("<td><a href='sumbit.jsp?id=" + h.getStudentid() + "&homeworkid=" + h.getHomeworkid() + "'>查看下载"
					+ "</a></td>");
					out.println("</tr>");
				}	%>		




			</tbody>
		</table>
	</div>
	
	<form method="post" action="login.jsp">

		<button type="submit" name="user_id" value="0">返回登录界面</button>

	</form>
</body>
<ml>