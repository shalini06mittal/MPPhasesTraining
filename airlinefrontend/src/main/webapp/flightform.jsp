<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Add New Flight</h2>
	<form action="add" method="post">
	<div>Name: <input type="text" name="flightname" ></div>
		<div>Source: <input type="text" name="source" ></div>
		<div>Destination: <input type="text" name="destination" ></div>
		<div>Price: <input type="text" name="price" ></div>
		<div>Start Time: <input type="text" name="starttime" ></div>
		<div>End Time: <input type="text" name="endtime" ></div>
		<div><input type="submit"></div>
	</form>
</body>
</html>