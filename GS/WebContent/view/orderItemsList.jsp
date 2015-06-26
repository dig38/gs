<%@ page import = "model.Customer"%> 
<%@ page import = "model.Order" %>
<%@ page import = "model.OrderItem" %>
<%@ page import = "model.Address" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.NumberFormat" %>
<%	@SuppressWarnings("unchecked") List<OrderItem> orderItems = (List<OrderItem>) request.getAttribute("orderItems"); %>
<h3>Order Items List</h3>
<table class="table table-hover">
	<tr>
		<th>ID</th>
		<th>Product</th>
		<th>Quantity</th>
		<th>Discount Amount</th>
	</tr>
<%	NumberFormat currency = NumberFormat.getCurrencyInstance();
	for(int index = 0; index < orderItems.size(); index++){ 
%>
	<tr>
		<td><%=orderItems.get(index).getItemId() %></td>
		<td><%=orderItems.get(index).getProduct().getProductName() %></td>
		<td><%=orderItems.get(index).getQuantity() %></td>
		<td><%=currency.format(orderItems.get(index).getDiscountAmount()) %></td>
	</tr>
<%	}
%>
</table>