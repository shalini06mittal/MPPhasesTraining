<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration System </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
  <style type="text/css">
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
		  <form action="edit" method="post">
		  <div class="row">
		  <div class="col-lg-6 col-lg-offset-3">
		  <div class="form-group">
		      <label for="username">UserName:</label>
		      <input type="text" class="form-control" id="username" value="${customer.username }"  name="username" readonly="readonly">
		    </div>
		    <div class="form-group">
		      <label for="name">Name:</label>
		      <input type="text" class="form-control" id="name" value="${customer.name }" placeholder="Enter Name" name="name">
		    </div>
		    
		    <div class="form-group">
		      <label for="phone">Phone:</label>
		      <input type="number" class="form-control" id="phone" value="${customer.phone }" placeholder="Enter phone no." name="phone">
		    </div>		    
		    <div class="form-group">
		      <label for="email">Email:</label>
		      <input type="email" class="form-control" id="email" value="${customer.email}" placeholder="Enter email" name="email">
		    </div>	    
		    <div class="form-group">
		    	<div class="form-check">
		    	
				  <input class="form-check-input" type="radio" name="gender" 
				  id="exampleRadios1" value="male" ${customer.gender=="male"?'checked':''}>
				  <label class="form-check-label" for="exampleRadios1">
				    Male
				  </label>
				</div>
				<div class="form-check">
				  <input class="form-check-input" type="radio"
				   name="gender" id="exampleRadios2" value="female" 
				   ${customer.gender=="female"?'checked':''}>
				  <label class="form-check-label" for="exampleRadios2">
				    Female
				  </label>
				</div>
		    </div>
		    <div class="form-group">
		    	<label for="inputCity">City</label>
		    	<select id="city" name="city" class="form">
		    		<option value="delhi" ${customer.city=='delhi'?'selected':'' }>Delhi</option>
		    		<option value="trivandrum" ${customer.city=='trivandrum'?'selected':'' }>Trivandrum</option>
		    		<option value="jaipur" ${customer.city=='jaipur'?'selected':'' }>Jaipur</option>
		    	</select>
		    </div>
		   
		    <div align="center"><button type="submit" class="btn btn-primary" value="Edit">Edit</button>
		    <button  class="btn btn-primary" value="Cancel" (click)="cancel()">Cancel</button>
		    </div>
		    </div>
		    </div>
		  </form>
		
</div>
 <script type="text/javascript">
 function cancel(){
	 location.href("admin.jsp");
 }
 </script>
</body>
</html>