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
	<h2>List of Flights</h2>
	<c:forEach items="${flights}" var="flight">
		<div style="color:brown; margin-bottom:2px;padding:20px">
		<p>Source: ${flight.source }</p>
		<p>destination: ${flight.destination }</p>
		<p>Price: ${flight.price }</p>
		<p>Start Time: ${flight.starttime }</p>
		<p>End Time: ${flight.endtime }</p>
		<hr/>
		</div> 
	</c:forEach>
</body>
</html>