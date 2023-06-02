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
</head>
<body>

	<div class="login">
		<table width="60%" border=1 class="hovertable">
			<thead>
				<tr>
					<th>学生id</th>
					<th>姓名</th>
					<th>班级</th>
					<th>民族</th>
					<th>地址</th>
					<th>政治面貌</th>
					
					
					<th></th>
				</tr>

			</thead>
			<tbody>
				<%
				List<Student> a1 = (List<Student>) request.getAttribute("allstu");

				for (Student h : a1) {
					out.println(
					"<tr onmouseover=\"this.style.backgroundColor='#ffff66';\" onmouseout=\"this.style.backgroundColor='#d4e3e5';\">");
					out.println("<td>" + h.getStuentid() + "</td>");
					out.println("<td>" + h.getName() + "</td>");
					out.println("<td>" + h.getClassid() + "</td>");
					out.println("<td>" + h.getNation() + "</td>");
					out.println("<td>" + h.getAddress() + "</td>");
					out.println("<td>" + h.getStatus() + "</td>");
					out.println("</tr>");
				}

				%>


			</tbody>
		</table>
	</div>
	<form method="get" action="Teacher.jsp">
		<button type="submit" name="login" value="2">返回登录界面</button>

	</form>
</body>
<ml>