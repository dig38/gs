<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.ServletContext" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="javax.servlet.RequestDispatcher" %>
<%
	if (request.getAttribute("flag") != "1"){						
		/* This block is to help my understanding of the line.
		 * ServletContext context = getServletContext();
		 * RequestDispatcher rd= context.getRequestDispatcher("/IndexController");
		 * rd.forward(request, response); 
		 */
		getServletContext().getRequestDispatcher("/IndexController").forward(request, response);
	}else{
%>
	<c:import url="/view/header.jsp" />
	<div class="container">
		<div class="starter-template">
		<h1>Customers</h1>
		<p class="lead">Select a customer to view their information: </p>
	</div>
		${message}
		${tableInfo}
		<br />
		<a style="float:right;" href="addCustomer.jsp" id="add" class="col-lg-3 col-md-3 col-sm-3 btn btn-primary">Add New Customer</a>
<%
	}	
%>
	</div><!-- /.container -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>