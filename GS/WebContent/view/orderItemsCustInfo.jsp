<%@ page import = "model.Customer"%> 
<%
	Customer cust = (Customer)  request.getAttribute("cust");	
%>
<h2>Customer</h2>

<form class="form-horizontal">
			
			//customerID
	<div class="form-group">
	<label for="customerID" class="col-sm-2 control-label">Customer ID</label>
	<div class="col-sm-10">
	<input type="text" class="form-control" id="customerID" placeholder="CustomerID" value="<%=cust.getCustomerId()%>" readonly >
	</div>
	</div>
			
			//name
	<div class="form-group">
	<label for="name" class="col-sm-2 control-label">Name</label>
	<div class="col-sm-10">
	<input type="text" class="form-control" id="name" placeholder="Name" value="<%= cust.getFirstName() + " " + cust.getLastName()%>" readonly />
	</div>
	</div>
			
			//email
	<div class="form-group">
	<label for="email" class="col-sm-2 control-label">Email</label>
	<div class="col-sm-10">
	<input type="text" class="form-control" id="email" placeholder="Email" value="<%= cust.getEmailAddress()%>" readonly />
	</div>
	</div>
			
	</form>