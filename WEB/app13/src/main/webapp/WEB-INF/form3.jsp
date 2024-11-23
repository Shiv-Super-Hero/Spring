<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br>
<h2 style="color:red;" align="center">Shivapuri Nagarjuna National Park</h2>
<h2 style="color:blue;" align="center">User Registration Page</h2>
<form:form method="post" commandName="user">
<center>
<table>
<tr>
	<td>User Email</td>
	<td><form:input path="uemail"/></td>
</tr>
<tr>
	<td>User Mobile No</td>
	<td><form:input path="umobile"/></td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" name="_target1" value="Back"/>
		<input type="submit" name="_finish" value="Finish"/>
		<input type="submit" name="_cancel" value="Cancel"/>
	</td>
</tr>
</table>
</center>
</form:form>
</body>
</html>