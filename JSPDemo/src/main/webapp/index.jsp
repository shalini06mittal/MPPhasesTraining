<!--  Page Directives : HTML comment -->
<%-- Page Directives : JSP comment --%>

<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
<div class="container">


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
					aria-current="page" href="welcome.jsp">Home</a></li>
				
				<li class="nav-item"><a class="nav-link" href="admin.jsp">Admin</a></li>
			</ul>

		</div>
	</div>
	</nav>
	<h1 align="center">Welcome to this Beautiful World Out Here!!</h1>
	<h3 align="center">Come Be a Part of It... The journey will be interesting</h3>

	<h4 align="center"><a href='customer.jsp'>Register</a> ( if not registered )</h4>
		<form action="login" method="post">
			<div class="row">
				<div class="col-lg-6 col-lg-offset-3">
					<div class="form-group">
						<label for="username">UserName:</label> <input type="text" value='shalu'
							class="form-control" id="email" placeholder="Enter Username"
							name="username">
					</div>
					<div class="form-group">
						<label for="password">Password:</label> 
						<input type="password" value='shalu'
							class="form-control" id="email" placeholder="Enter Password"
							name="password">
					</div>
					
					  <div align="center" class='mt-3'>
					  <button type="submit" class="btn btn-primary" value="Login">Login</button></div>
				</div>
			</div>
		</form>
	</div>
	<%-- <h1>JSP Demo</h1>
	<h3><%= LocalDate.now() %></h3>
	
	<%
		List<String> colors = Arrays.asList("red","green","blue");
		for(String color:colors){
			out.println(color);
		}
		for(int i=1;i<=10;i++){
			out.println("<p>"+ i*i +"</p>");
		}
	%> --%>
</body>
</html>