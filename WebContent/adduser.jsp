<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User</title>
</head>
<body>
<form action="CreateUserServelet" method="post">
	User Name:&nbsp;&nbsp;<input type ="text" name = "username"><br/>
	Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email"><br/>
	Password:&nbsp;<input type="password" name="password"><br/>
	Motto:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="motto"><br/>
	<input type="hidden" name="action" value="createuser">
	<input type="submit" value="Create">
</form>
</body>
</html>