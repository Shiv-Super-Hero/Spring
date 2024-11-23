<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:red;" align="center">Jacobin's Club New Delhi</h2>
<h3 style="color:blue;" align="center">Student Registration Form</h3>
<center>
<table>
<tr>
	<td>User Name</td>
	<td>${user.uname}</td>
</tr>
<tr>
	<td>User Password</td>
	<td>${user.upwd}</td>
</tr>
<tr>
	<td>User Age</td>
	<td>${user.uage}</td>
</tr>
<tr>
	<td>User Date Of Birth</td>
	<td>${user.udob}</td>
</tr>
<tr>
	<td>User Email Id</td>
	<td>${user.uemail}</td>
</tr>
<tr>
	<td>User Mobile No</td>
	<td>${user.umobile}</td>
</tr>
</table>
</center>
</body>
</html>