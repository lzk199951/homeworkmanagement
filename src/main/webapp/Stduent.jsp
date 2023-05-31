<%@ page language="java" import="Dao.StudentHomeworkDao,Model.StudentHomework,java.util.List" pageEncoding="utf-8"%>
<%@ page language="java" import="Dao.StudentDao,Model.Student,java.util.List" pageEncoding="utf-8"%>
<%@ page language="java" import="Dao.StudentDao,Model.Student,java.util.List" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>欢迎您的使用</title>
<style>
*{margin:0;
padding:0;
box-sizing:border-box;
}
body {
    background: url(./几何背景1.png) no-repeat center 0px fixed;
    background-size: cover;
    font-family: "微软雅黑", sans-serif;
}
.login { 
    position: absolute;
    top: 40%;
    left: 40%;
    margin: -150px 0 0 -150px;
    width:900px;
    height:300px;
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
				if(confirm(msg)){
				    return true;
				}else{
				    return false;
				}
			   }
			</script>
	</head>
	<body>
	<div class="login">
	   <a href="information.jsp">个人信息管理</a>  
	   <a href="homeworkcontent.jsp">查看作业详情</a>
	   <a href="user.jsp">提交作业</a>
	   <table width="60%" border=1 class="hovertable">
	   <thead>
	      <tr><th></th><th>作业详情</th><th>截至时间</th><th>课程id</th><th></th></tr>
	   </thead>
	   <tbody>
	   <%
	   String user_id=request.getParameter("user_id");
	   StudentDao sDao=new StudentDao();
	   Student sus=new Student();
		sus=sDao.queryStudentByID(user_id);
		String classid=sus.getClassid();
	   
	     

	     
	   %>
	   </tbody>
	   </table>	
	   </div> 
</body>
<ml>
