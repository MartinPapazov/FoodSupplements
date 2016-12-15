<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="fs" uri="http://fs.com/tags" %>
<html>
<head>
<title>Home</title>
<meta charset="UTF-8" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link
	href="${pageContext.request.contextPath}/resources/theme1/css/menu.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
	
	<fs:Menu></fs:Menu>

		<h1>Hello Food Supplement Store! Customer ${customer.username}.</h1>

		<P>The time on the server is ${serverTime}.</P>

		<div class="row">
			<div class="col-*-*" style="background-color: red">sdadsa</div>
		</div>
		<a href="logout"> Logout </a>
		<%
			if (request.isUserInRole("ADMIN")) {
		%>
		<form action="admin/home" method="GET">
			<input type="submit" name="admin_button" value="Admin Panel">
		</form>
		<%
			}
		%>
		
		<a class="back-to-top glyphicon glyphicon-arrow-up" href="#" title="Top" style="width: 20px; height: 20px;"></a>
	</div>
</body>
</html>
