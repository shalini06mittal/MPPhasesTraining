<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome To Flight Management System</h1>

	<p>
		<a href="add">Add Flight</a>
	</p>
	<p>
		<a href="list">Flights</a>
	</p>

	<form action="list">
		<p> Source : <input type="text" name="source"/></p>
		<p> Destination : <input type="text" name="destination"/></p>
		<p> <input type="submit" value="Search Flight"/></p>
	</form>

</body>
</html>