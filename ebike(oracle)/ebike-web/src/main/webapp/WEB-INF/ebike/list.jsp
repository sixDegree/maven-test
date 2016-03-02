<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css"> --%>
<title>ProductList</title>
</head>
<body>
<h2>ProductList</h2>
Welcome <br/>
<a href="add">Add New Product</a> | <a href="<%=path %>/j_spring_security_logout">LogOut</a> 
<table style="font-size:14px;font-weight:bold;" width="90%" >
<tr style="font-size: 20px; color:green;background-color: yellow;">
<td>Id</td>
<td>productNameEn</td>
<td>productNameGm</td>
<td>image</td>
<td>isShow</td>
<td>createDate</td>
<td>Operation</td>
</tr>
<c:forEach items="${products}"  var="p">
<tr style="background-color:green;color:yellow;">
	<td>${p.id}</td>
	<td>${p.productNameEn }</td>
	<td>${p.productNameGm }</td>
	<td>${p.imageUrl }</td>
	<td>${p.isShow }</td>
	<td>${p.createDate }</td>
	<td> <a href="${p.id}">Details</a>  | <a href="${p.id}/update">Update</a>  | <a href="${p.id}/delete">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>