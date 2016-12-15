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
	<form name="login" action="/store/addCustomer" method="POST">
		<label> Username: + // ajax check //</label>
		<input type="text" name="username"><br />
		<label> Password: </label>
		<input type="password"  name="password"> <br />
		
		<label> Repeat password: + // js check //</label>
		<input type="password" name="password_repeat"> <br />
		<label> Email: + // ajax check //</label>
		<input type="text" name="email"><br />
		
		<input type="submit" name="submit" value="Sign in">
	</form>
</body>
</html>