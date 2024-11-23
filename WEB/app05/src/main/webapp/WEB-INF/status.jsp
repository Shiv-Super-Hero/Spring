<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Shivaji Rajnkant Foundations</h2>
<h3>User Login Status</h3>
<br><br>
<h1>Status : <%= session.getAttribute("status") %></h1>
<h3><a href="./loginpage">|Login Form|</a></h3>
</center>
</body>
</html>