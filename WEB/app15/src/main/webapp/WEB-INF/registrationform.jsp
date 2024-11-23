<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:red;" align="center">Jacobin's Club New Delhi</h2>
<h3 style="color:blue;" align="center">Student Registration Form</h3>
<form:form method="post" action="reg" commandName="user">
<center>
<table>
<tr>
	<td>User Name</td>
	<td><form:input path="uname"/></td>
</tr>
<tr>
	<td>User Password</td>
	<td><form:password path="upwd"/></td>
</tr>
<tr>
	<td>User Age</td>
	<td><form:input path="uage"/></td>
</tr>
<tr>
	<td>User Date Of Birth</td>
	<td><form:input path="udob"/></td>
</tr>
<tr>
	<td>User Email Id</td>
	<td><form:input path="uemail"/></td>
</tr>
<tr>
	<td>User Mobile No</td>
	<td><form:input path="umobile"/></td>
</tr>
<tr>
	<td><input type="submit" value="Registration"/></td>
</tr>
</table>
</center>
</form:form>
</body>
</html>