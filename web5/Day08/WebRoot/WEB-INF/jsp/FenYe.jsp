<%@ page language="java" import="java.util.*,com.company.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FenYe.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style>
       div{
          position: absolute;
          left: 200px;
          top: 100px;
          border: 2px solid black;
       }
       #right{
          position: absolute;
          left: 240px;
          top: 200px;
       }
        #left{
          position: absolute;
          left: 100px;
          top: 200px;
       }
        #lb{
          position: absolute;
          left: 160px;
          top: 200px;
       }
    </style>
    <%
         List<User> userList = (List<User>) request.getAttribute("list");
         int currentPage = (Integer) session.getAttribute("currentPage");
         String downMSG = (String) request.getAttribute("downMSG");
         System.out.println(downMSG);
         if(downMSG == null){
            downMSG = "下一页";
         }
     %>
  </head>
  
  <body>
  <div>
    <table border="2" cellspacing="0">
       <tr>
          <th>uid</th>
          <th>uname</th>
          <th>uage</th>
          <th>uphone</th>
          <th>ugender</th>
       </tr>
       <%for(int i = 0; i < userList.size(); i ++) {%>
         <tr>
            <td><%=userList.get(i).getUid() %></td>
            <td><%=userList.get(i).getUname() %></td>
            <td><%=userList.get(i).getUage() %></td>
            <td><%=userList.get(i).getUphone() %></td>
            <td><%=userList.get(i).getUgender() %></td>
         </tr>
       <%} %>
    </table>
    <form id="right" action="DownServlet" method="get">
      <input type="submit" value=<%=downMSG %>>
    </form>
    <label id="lb"><%=currentPage %></label>
    <form id="left" action="UpServlet" method="get">

       <input type="submit" value="上一页">
    </form>
  </div>
  </body>
</html>
