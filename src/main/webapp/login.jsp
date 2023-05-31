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
.login { 
    position: absolute;
    top: 50%;
    left: 50%;
    margin: -150px 0 0 -150px;
    width:300px;
    height:300px;
}
.login h1 { 
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
<div class="login">
  <h1>Login</h1>   
    <form  method="post" action="loginServlet">	
           <input type="text" name="user_id" placeholder="用户名" required="required">
           <input type="password" name="pwd" placeholder="密  码" required="required">
           <button type="submit" name="login" value="0">教师登录</button>
           <button type="submit" name="login" value="1">学生登录</button> 
           <button type="submit" name="login" value="2">管理员登录</button>      		
    </form>	  
    <%    
    if( request.getAttribute("loginmsg")!=null){%>
    	
    	<%=request.getAttribute("loginmsg") %>
    	
    	<%} %>
    
    
 
</div>     
</body>
</html>