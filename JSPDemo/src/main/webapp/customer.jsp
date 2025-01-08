<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration System </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<!-- Optional Bootstrap theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/jquery-1.11.3.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 -->  <style type="text/css">
  	.error{
  		color:red;
  		font-size: 20px;
  	}
  </style>
</head>
<body>
	<h2 align="center">Customer Registration System </h2>
	<%
	String error = (String)request.getAttribute("error");
	if(error != null){ %>
	<p align="center" class='error'><%= error%> </p><%} %>
<div class="container">
		  <form action="Register" method="post">
		  <div class="row">
		  <div class="col-lg-6 col-lg-offset-3">
		    <div class="form-group">
		      <label for="name">Name:</label>
		      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
		    </div>
		    
		    <div class="form-group">
		      <label for="phone">Phone:</label>
		      <input type="number" class="form-control" id="phone" placeholder="Enter phone no." name="phone">
		    </div>		    
		    <div class="form-group">
		      <label for="email">Email:</label>
		      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
		    </div>	    
		     <div class="form-group">
		      <label for="username">UserName:</label>
		      <input type="text" class="form-control" id="email" placeholder="Enter Username" name="username">
		    </div>
		     <div class="form-group">
		      <label for="password">Password:</label>
		      <input type="password" class="form-control" id="email" placeholder="Enter Password" name="password">
		    </div>
		    <div class="form-group">
		    	<div class="form-check">
				  <input class="form-check-input" type="radio" name="gender" id="exampleRadios1" value="male" checked>
				  <label class="form-check-label" for="exampleRadios1">
				    Male
				  </label>
				</div>
				<div class="form-check">
				  <input class="form-check-input" type="radio" name="gender" id="exampleRadios2" value="female">
				  <label class="form-check-label" for="exampleRadios2">
				    Female
				  </label>
				</div>
		    </div>
		    <div class="form-group">
		    	<label for="inputCity">City</label>
		    	<select id="city" name="city" class="form">
		    		<option value="delhi">Delhi</option>
		    		<option value="trivandrum" selected>Trivandrum</option>
		    		<option value="jaipur">Jaipur</option>
		    	</select>
		    </div>
		   
		    <div align="center"><button type="submit" class="btn btn-primary" value="Register">Register</button></div>
		    </div>
		    </div>
		  </form>
</div>
 
</body>
</html>