<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Welcome to our fs system</h1>
	<br />
	<form name="login" action="/store/login" method="POST">
		<label> Username: </label>
		<input type="text" id="username" name="username"><br />
		<label> Password: </label>
		<input type="password" id="password" name="password"> <br />
		<input type="submit" name="submit" value="Login">
	</form>
	
	<a href="signin"> Sign in </a>
</body>
</html>