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
    <form  method="post" action="HomeworkmangeServlet">	
    
          
           <button type="submit" name="homework" value="0">查看作业</button>
  
           <button type="submit"  name="homework"  value="1">布置作业</button> 
    
           <button type="submit"  name="homework"  value="2">批改作业</button>      		
    </form>	  
    <%    
    if( request.getAttribute("homeworkmsg")!=null){%>
    	
    	<%=request.getAttribute("homeworkmsg") %>
    	
    	<%} %>
    
    
 
</div>     
</body>
</html>