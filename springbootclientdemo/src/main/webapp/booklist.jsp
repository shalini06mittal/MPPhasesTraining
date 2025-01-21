<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>List of Books</h2>
	<c:forEach items="${books}" var="book">
		<div style="color:brown; margin-bottom:2px;padding:20px">
		<p>Id: ${book.bookid }</p>
		<p>Title: ${book.title }</p>
		<p>Price: ${book.price }</p>
		<p>Author: ${book.author }</p>
		<hr/>
		</div> 
	</c:forEach>
</body>
</html>