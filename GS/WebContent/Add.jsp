<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.*" %>
<%@page import="javax.servlet.RequestDispatcher" %>
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
			<p class="lead">Enter the customer information: </p>
		</div>
	
		<form class="form-horizontal" action="AddCustomerController" method="post">

		<!-- 
		<div class="form-group">
			<label for="customerID" class="col-sm-2 control-label">Customer ID</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="customerID" id="customerID" placeholder="Customer ID" value="" >
			</div>
		</div>
	 	-->
	
		<div class="form-group">
			<label for="fname" class="col-sm-2 control-label">First Name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="fname" id="fname" placeholder="First Name" value="" required>
			</div>
		</div>
		
		<div class="form-group">
			<label for="lname" class="col-sm-2 control-label">Last Name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="lname" id="lname" placeholder="Last Name" value="" required>
			</div>
		</div>
		
		<!-- 
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="email" id="email" placeholder="Email" value="" required>
			</div>
		</div>
		-->
		
		<h3>Home Address</h3>
	
		<div class="form-group">
			<label for="phone1" class="col-sm-2 control-label">Phone 1</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="phone1" id="phone1" placeholder="Phone 1" value="" >
			</div>
		</div>
	
		<div class="form-group">
			<label for="address1L1" class="col-sm-2 control-label">Address Line 1</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="address1L1" id="address1L1" placeholder="Address Line 1" value="" >
			</div>
		</div>
	
		<div class="form-group">
			<label for="address1L2" class="col-sm-2 control-label">Address Line 2</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="address1L2" id="address1L2" placeholder="Address Line 2" value="" >
			</div>
		</div>
	
		<div class="form-group">
			<label for="city1" class="col-sm-2 control-label">City</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="city1" id="city1" placeholder="City" value="" >
			</div>
		</div>
	
		<div class="form-group">
			<label for="state1" class="col-sm-2 control-label">State</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="state1" id="state1" placeholder="State" value="" >
			</div>
		</div>
	
		<div class="form-group">
			<label for="zip1" class="col-sm-2 control-label">Zip Code</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="zip1" id="zip1" placeholder="Zip Code" value="" >
			</div>
		</div>
	

		<h3>Shipping Address</h3>
	
		<div class="form-group">
			<label for="phone2" class="col-sm-2 control-label">Phone 2</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="phone2" id="phone2" placeholder="Phone 2" value="" >
			</div> 
		</div>
	
		<div class="form-group">
			<label for="address2L1" class="col-sm-2 control-label">Address Line 1</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="address2L1" id="address2L1" placeholder="Address Line 1" value="" >
			</div>
		</div>
	
		<div class="form-group">
			<label for="address2L2" class="col-sm-2 control-label">Address Line 2</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="address2L2" id="address2L2" placeholder="Address Line 2" value="" >
			</div>
		</div>
				
		<div class="form-group">
			<label for="city2" class="col-sm-2 control-label">City</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="city2" id="city2" placeholder="City" value="" >
			</div>
		</div>
		
		<div class="form-group">
			<label for="state2" class="col-sm-2 control-label">State</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="state2" id="state2" placeholder="State" value="" >
			</div>
		</div>
		
		<div class="form-group">
			<label for="zip2" class="col-sm-2 control-label">Zip Code</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="zip2" id="zip2" placeholder="Zip Code" value="" >
			</div>
		</div>
		
		
		<div class="form-group">
			<button class="col-sm-offset-9 col-sm-3 btn btn-primary" type="submit">Add Customer</button>
		</div>
		
		
		
		</form>
	</div><!-- /.container -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>