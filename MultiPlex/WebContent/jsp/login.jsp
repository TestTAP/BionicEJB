<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movieplex</title>
</head>
<body>
	<h1>Welcome to MultiPlex!</h1>
	<h3>Please login</h3>
	<hr />
	<form action="controller" name="loginForm" method="POST">
		<input type="hidden" name="command" value="login" /> 
		Login:
		<br /> 
		<input	type="text" name="login" value=""><br /> 
		Password:
		<br /> 
		<input type="password" name="password" value="">
		<br/> 
		<input type="submit" value="Enter">
	</form>
	<hr />
</body>
</html>