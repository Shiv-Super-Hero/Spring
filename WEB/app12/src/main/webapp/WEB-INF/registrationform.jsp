<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:red;" align="center">Chhatrapati Shivaji Maharaj Foundation</h2>
<h3 style="color:blue;" align="center">User Registration Page</h3>
<form:form method="post" action="reg" commandName="user">
<center>
<table>
<tr>
	<td>User Name</td>
	<td><form:input path="uname" size="20"/></td>
</tr>
<tr>
	<td><input type="submit" value="Registration"/></td>
</tr>
</table>
</center>
</form:form>
</body>
</html>