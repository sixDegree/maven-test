<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>User Login</h2>
Reason:${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}  
<form method="post"  action="<%=path%>/j_spring_security_check"> <!-- action="common/login-process" --> 
<table>
<tr><td>UserName:</td><td><input name="j_username" type="text"/></td></tr>
<tr><td>Password:</td><td><input type="password" name="j_password"/></td></tr>
<tr><td><input type="checkbox" name="_spring_security_remember_me" />两周之内不必登陆  </td></tr>
<tr><td><button type="reset">Reset</button></td><td><button type="submit">Submit</button></td></tr>
</table>
</form>
</body>
</html>