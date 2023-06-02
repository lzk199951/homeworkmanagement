<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>老师界面</title>
</head>
<body>
<%
String teacherid = (String) request.getAttribute("teacherid");
System.out.println(teacherid);
request.getSession().setAttribute("teacherid", teacherid);
%>
<ul>
  <li><a href="Studentmanger.jsp">学生管理</a></li>
  <li><a href="Homemanger.jsp">作业管理</a></li>
  <li><a href="coursemanger.jsp">课程管理</a></li>
  
  
</ul>
</body>
</html>