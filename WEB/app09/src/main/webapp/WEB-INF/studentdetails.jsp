<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br>
<h2 style="color:red" align="center">Shivaji Chandrasekhar Foundation</h2>
<h3 style="color:blue" align="center">Student Details Page</h3>
<center>
<table border="1">
	<tr>
		<th>Student Id</th>
		<td>${sto.sid}</td>
	</tr>
	<tr>
		<th>Student Name</th>
		<td>${sto.sname}</td>
	</tr>
	<tr>
		<th>Student Address</th>
		<td>${sto.saddr}</td>
	</tr>
</table>
</center>
</body>
<h3>
<a href="homepage">Home Page</a>
</h3>
</html>