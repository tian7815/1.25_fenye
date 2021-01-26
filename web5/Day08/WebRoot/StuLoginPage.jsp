<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'StuLoginPage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%
		String res = (String)request.getAttribute("msg");
		if(res ==null){
			res="";
		}
	 %>

  </head>
  
  <body>
    <form action="stuLoginServlet" method="post">
    	<label><%=res %></label>
    	<lable>账号：</lable><input type="text" name="idtext"/><br>
    	<lable>密码：</lable><input type="password" name="passtext"><br>
    	<input type="submit" value="登录"/>
    </form>
  </body>
</html>
