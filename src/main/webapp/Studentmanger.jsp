<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>登录界面</title> 
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
.student { 
    position: absolute;
    top: 50%;
    left: 50%;
    margin: -150px 0 0 -150px;
    width:300px;
    height:300px;
}
.student h1 { 
    color:#555555;
    text-shadow: 0px 10px 10px #CDC673;
    letter-spacing:2px;text-align:center;
    margin-bottom:20px;
}
input{
    padding:10px;
    width:100%;
    color:white;
    margin-bottom:10px;
    background-color:#555555;
    border: 1px solid black;
    border-radius:5px;
    letter-spacing:2px;
}
form button{
    width:100%;
    padding:10px;
    margin-bottom:10px;
    background-color:#b0c4de;
    border:1px solid black;
    border-radius:5px;
    cursor:pointer; 
}                                                                                                                                       
</style>
</head>
<body> 
<div class="headtop"></div>
<div class="student">
  <h1>studentmange</h1>   
    <form  method="post" action="AddStudentServlet">	
           学生Id: <input type="text" name="studentid">
           学生姓名:<input type="text" name="studentname">
           学生密码: <input type="text" name="studentpassword">
           学生班级:<input type="text" name="studentclass">
           
           <button type="submit" name="student" value="0">增加学生</button>
           
           待删除学号:<input type="text" name="studentdeleteid">
           <button type="submit" name="student" value="1">删除学生</button> 
           查看所教课程班级的学生:
           <button type="submit" name="student" value="2">查看学生信息</button>      		
    </form>	  
    <%    
    if( request.getAttribute("studentmsg")!=null){%>
    	
    	<%=request.getAttribute("studentmsg") %>
    	
    	<%} %>
    
    
 
</div>     
</body>
</html>