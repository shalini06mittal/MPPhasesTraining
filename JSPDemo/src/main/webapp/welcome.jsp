<%@page import="java.time.LocalDate"%>
<%@page import="model.Invoice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.InvoiceDatabase"%>
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
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");//http1.0
	response.setHeader("Pragma", "0");//proxies
	%>

	<%
	if (session.getAttribute("username") != null) {
	%>
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
				<li class="nav-item"><a class="nav-link" href="profile.jsp">Profile</a></li>
				<li class="nav-item"><a class="nav-link" href="logout.jsp">Logout</a></li>
			</ul>

		</div>
	</div>
	</nav>
	<h3 class='text-center m-3'>
		Welcome
		<%=session.getAttribute("username")%></h3>

	<%
		InvoiceDatabase database = new InvoiceDatabase();
		String date = request.getParameter("invdate");
		ArrayList<Invoice> invoices = new ArrayList<>();
		if(date!=null){
			LocalDate invdate = LocalDate.parse(date);
			invoices = database.getInvoicesByDateForCustomer((String)session.getAttribute("username"), invdate);
		}
		else
	    	invoices = database.getInvoicesByCustomer((String) session.getAttribute("username"));
	  %>
	<div class='container'>
		
		
		<% if(invoices.size() > 0){ %>
		<form action ='welcome.jsp'>
			<input type='date' name='invdate' value="<%=date %>"/> <input type='submit'/>
		</form>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Invoice No</th>
					<th scope="col">Amount</th>
					<th scope="col">Invoice Date</th>
					<th scope="col">Delivery Date</th>
					<th scope="col">Address</th>
				</tr>
			</thead>
			<tbody>
				<% for(Invoice invoice: invoices) {%>
				<tr>
					<th scope="row"><%= invoice.getInvno() %></th>
					<td><%= invoice.getAmount() %></td>
					<td><%= invoice.getInvdate() %></td>
					<td><%= invoice.getDeldate() %></td>
					<td><%= invoice.getAddress() %></td>
				</tr>
				<%} %>
			</tbody>
		</table>
		<%} else{
			out.println("<p>No invoices yet</p>");
		}
			%>
		
		<div></div>
		<%
		} else {
			response.sendRedirect("index.jsp");
		}
		%>
	</div>
</body>
</html>