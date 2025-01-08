<%@page import="dao.CustomerDatabase"%>
<%@page import="model.Customer"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>


<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">CMS</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp">Home</a></li>
			</ul>

		</div>
	</div>
	</nav>
	
	<div class='container'>
	<h1>Customer's List :</h1>
	<table class='table'>
		<tr>
			<th>Name</th>
			<th>City</th>
			<th>Phone</th>
			<th>Gender</th>
			<th>Email</th>
		</tr>
		<%
			
				ArrayList<Customer> customers = new CustomerDatabase().getCustomers();
				for (Customer c : customers) {
		%>
		<tr>
			<td><%=c.getName()%></td>
			<td><%=c.getCity()%></td>
			<td><%=c.getPhone()%></td>
			<td><%=c.getGender()%></td>
			<td><%=c.getEmail()%></td>
			<td><a href='edit?username=<%=c.getUsername()%>'>Edit</a></td>
			<td><a href='delete?username=<%=c.getUsername()%>'>Delete</a></td>
		</tr>
		<%} %>
	</table>
	</div>
</body>
</html>