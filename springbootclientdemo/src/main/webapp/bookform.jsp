<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Add New Book</h2>
	<form action="add" method="post">
		<div>Title: <input type="text" name="title" ></div>
		<div>Description: <input type="text" name="desc" ></div>
		<div>Price: <input type="text" name="price" ></div>
		<div>Author: <input type="text" name="author" ></div>
		<div><input type="submit"></div>
	</form>
</body>
</html>