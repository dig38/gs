<%@ page import = "model.Customer"%> 
<%@ page import = "model.Order" %>
<%@ page import = "model.Address" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.NumberFormat" %>

<%
	Customer cust = (Customer)  request.getAttribute("cust");	
	@SuppressWarnings("unchecked") List<Order> orders = (List<Order>) request.getAttribute("orders");
	Address a1 = (Address) request.getAttribute("a1");
	Address a2 = (Address) request.getAttribute("a2");
%>
		<form class="form-horizontal" action="edit" method="post">
			
		<div class="form-group">
		<label for="customerID" class="col-sm-2 control-label">Customer ID</label>
		<div class="col-sm-10">
		<input type="text" class="form-control" id="customerID" placeholder="CustomerID" value=" <%= cust.getCustomerId() %>  " readonly >
		</div>
		</div>
			
		<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name</label>
		<div class="col-sm-10">
		<input type="text" class="form-control" id="name" placeholder="Name" value="<%= cust.getFirstName() %>&nbsp;<%= cust.getLastName() %>" readonly />
		</div>
		</div>
			
		<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email</label>
		<div class="col-sm-10">
		<input type="text" class="form-control" id="email" placeholder="Email" value="<%= cust.getEmailAddress() %>" readonly />
		</div>
		</div>
				
		<h3>Billing Address</h3>
			
		<div class="form-group">
		<label for="phone1" class="col-sm-2 control-label">Phone 1</label>
		<div class="col-sm-10">
		<input type="text" class="form-control" id="phone1" placeholder="Phone 1" value="<%= a1.getPhone()%>" readonly />
		</div> 
		</div>
			
		<div class="form-group">
		<label for="address1L1" class="col-sm-2 control-label">Address Line 1</label>
		<div class="col-sm-10">
		<input type="text" class="form-control" id="address1L1" placeholder="Home Address Line 1" value="<%= a1.getLine1() %>" readonly />
		</div>
		</div>
			
		<div class="form-group">
		<label for="address1L2" class="col-sm-2 control-label">Address Line 2</label>
		<div class="col-sm-10">
		<input type="text" class="form-control" id="address1L2" placeholder="Address Line 2" value="<%= a1.getLine2() %>" readonly />
		</div>
		</div>
			
		<div class="form-group">
		<label for="city1" class="col-sm-2 control-label">City</label>
		<div class="col-sm-10">
		<input type="text" class="form-control" id="city1" placeholder="City" value="<%= a1.getCity() %>" readonly />
		</div>
		</div>
			
		<div class="form-group">
		<label for="state1" class="col-sm-2 control-label">State</label>
		<div class="col-sm-10">
		<input type="text" class="form-control" id="state1" placeholder="State" value="<%= a1.getState() %>" readonly />
		</div>
		</div>
			
		<div class="form-group">
		<label for="zip1" class="col-sm-2 control-label">Zip Code</label>
		<div class="col-sm-10">
		<input type="text" class="form-control" id="zip1" placeholder="Zip Code" value="<%= a1.getZipCode() %>" readonly />
		</div>
		</div>
			
		<h3>Shipping Address</h3>
			
		<div class="form-group">
		<label for="phone2" class="col-sm-2 control-label">Phone 2</label>
		<div class="col-sm-10">
		<input type="text" class="form-control" id="phone2" placeholder="Phone 2" value="<%= a2.getPhone()%>" readonly />
		</div> 
		</div>
			
		<div class="form-group">
		<label for="address2L1" class="col-sm-2 control-label">Address Line 1</label>
		<div class="col-sm-10">
		<input type="text" class="form-control" id="address2L1" placeholder="Address Line 1" value="<%= a2.getLine1() %>" readonly />
		</div>
		</div>
			
		<div class="form-group">
		<label for="address2L2" class="col-sm-2 control-label">Address Line 2</label>
		<div class="col-sm-10">
		<input type="text" class="form-control" id="address2L2" placeholder="Address Line 2" value="<%= a2.getLine2() %>" readonly />
		</div>
		</div>
			
		<div class="form-group">
		<label for="city2" class="col-sm-2 control-label">City</label>
		<div class="col-sm-10">
		<input type="text" class="form-control" id="city2" placeholder="City" value="<%= a2.getCity() %>" readonly />
		</div>
		</div>
			
		<div class="form-group">
		<label for="state2" class="col-sm-2 control-label">State</label>
		<div class="col-sm-10">
		<input type="text" class="form-control" id="state2" placeholder="State" value="<%= a2.getState() %>" readonly />
		</div>
		</div>
			
		<div class="form-group">
		<label for="zip2" class="col-sm-2 control-label">Zip Code</label>
		<div class="col-sm-10">
		<input type="text" class="form-control" id="zip2" placeholder="Zip Code" value="<%= a2.getZipCode() %>" readonly />
		</div>
		</div>
			
		<!-- delete  -->	
		<div class="form-group"><div class="col-sm-12">
		<button class="col-sm-offset-8 col-sm-2 btn btn-primary" id="Edit">Edit User</button>
		<a class="col-sm-offset-0 col-sm-2 btn btn-danger" href="Delete?cusID<%=cust.getCustomerId()%>">Delete User</a>
		</div>
		</div>
		</form>
		
		
			<h3>Orders</h3>
			<table class="table table-hover">
			<tr>
				<th>Order ID</th>
				<th>Order Date</th>
				<th>Shipping Amount</th>
			</tr>
		<%	
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			for(int index = 0; index < orders.size(); index++){ 
		%>
		<% System.out.println(index); %>
				<tr>
					<td><a href='OrderListController?cusID=<%=cust.getCustomerId()%>&ordID<%=index%>' ><%= orders.get(index).getOrderId() %></a></td>
					<td> <%= orders.get(index).getOrderDate()%> </td>
					<td> <%= currency.format(orders.get(index).getShipAmount())%> </td>
				</tr>
		<%	
			}//END FOR
		%>
			</table>