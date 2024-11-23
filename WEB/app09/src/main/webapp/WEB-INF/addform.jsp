<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:red" align="center">Shivaji Foundations</h2>
<h3 style="color:blue" align="center">Student Add Page</h3>
<form method="post" action="add">
	<center>
		<table>
			<tr>
				<td>Student Id</td>
				<td><input type="text" name="sid"/></td>
			</tr>
			<tr>
				<td>Student Name</td>
				<td><input type="text" name="sname"/></td>
			</tr>
			<tr>
				<td>Student Address</td>
				<td><input type="text" name="saddr"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="ADD"/></td>
			</tr>
			
		</table>
	</center>
</form>
</body>
</html>