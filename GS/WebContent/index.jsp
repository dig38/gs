<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.*" %>
<%@page import="javax.servlet.RequestDispatcher" %>
<%
	if (request.getAttribute("flag") != "1"){						
		ServletContext context = getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/IndexController");
		rd.forward(request, response);					
	}else{
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Product Data</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<link rel="stylesheet" type="text/css" href="css/mycss.css">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="container">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">Guitar Shop</a>
	</div>
	<div id="navbar" class="collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active"><a href="index.jsp">Home</a></li>
		</ul>
	</div><!--/.nav-collapse -->
</div>
	</nav>
<br />
<br />
	<div class="container">
		<div class="starter-template">
		<h1>Customers</h1>
		<p class="lead">Select a customer to view their information: </p>
	</div>
		${message}
		${tableInfo}
		<br />
		<a style="float:right;" href="Add.jsp" id="add" class="col-lg-3 col-md-3 col-sm-3 btn btn-primary">Add New Customer</a>
<%
	}	
%>
	</div><!-- /.container -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>