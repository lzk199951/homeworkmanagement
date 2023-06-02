 <%@page contentType="text/html;charset=utf-8"%>
 <html>
 <body>
     <Form action="SumbitServlet?homeworkid=<%out.println(request.getParameter("homeworkid"));%>" method="post" ENCTYPE="multipart/form-data">
        作业内容：<input type="text" name="homeworkcontent"/><br>
         附件：<input type="file" name="userimage"/><br>
 
        
       <input type=submit>
     </Form>

 </body>
 </html>
