package controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.Address;
import model.Order;
import modelcontroller.CustomerMC;

/**
 * SERVLET implementation class customerPage
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Address> custAddresses = null;
		
		Address a1 = null, a2 = null;
		String CusInfo = "", ordInfo = "", message = "";
		String cusId = request.getParameter("cusID"); 
		String title = "Customer Information";
		request.setAttribute("title", title);
		
		
		try {
			
			Customer cust = CustomerMC.getOneCustomer(cusId);
			custAddresses = cust.getAddresses();
	
			int index = 0;
			if (Long.parseLong(cust.getShippingAddressId().toString()) == Long.parseLong(cust.getBillingAddressId().toString())){
					a1 = custAddresses.iterator().next();
					a2 = a1;
			}
			else{
				while(index < custAddresses.size()  && custAddresses.get(index) != null){			
					if(custAddresses.get(index).getAddressId() == Long.parseLong(cust.getBillingAddressId().toString()))
						a1 = custAddresses.get(index);
					if(custAddresses.get(index).getAddressId() == Long.parseLong(cust.getShippingAddressId().toString()))
						a2 = custAddresses.get(index);
					index++;
				}
			}//END if
			CusInfo += "<h2>Customer</h2>";
			
			CusInfo += "<form class=\"form-horizontal\" action=\"delete\" method=\"post\">";
			
			//customerID
			CusInfo += "<div class=\"form-group\">";
			CusInfo += "<label for=\"customerID\" class=\"col-sm-2 control-label\">Customer ID</label>";
			CusInfo	+= "<div class=\"col-sm-10\">";
			CusInfo	+= "<input type=\"text\" class=\"form-control\" id=\"customerID\" placeholder=\"CustomerID\" value=\" "+cust.getCustomerId() +" \" readonly >";
			CusInfo	+= "</div>";
			CusInfo	+= "</div>";
			
			//name
			CusInfo += "<div class=\"form-group\">";
			CusInfo += "<label for=\"name\" class=\"col-sm-2 control-label\">Name</label>";
			CusInfo	+= "<div class=\"col-sm-10\">";
			CusInfo += "<input type=\"text\" class=\"form-control\" id=\"name\" placeholder=\"Name\" value=\""+ cust.getFirstName() + " " + cust.getLastName() +"\" readonly />";
			CusInfo += "</div>";
			CusInfo	+= "</div>";
			
			//email
			CusInfo += "<div class=\"form-group\">";
			CusInfo += "<label for=\"email\" class=\"col-sm-2 control-label\">Email</label>";
			CusInfo	+= "<div class=\"col-sm-10\">";
			CusInfo += "<input type=\"text\" class=\"form-control\" id=\"email\" placeholder=\"Email\" value=\""+ cust.getEmailAddress() +"\" readonly />";
			CusInfo += "</div>";
			CusInfo	+= "</div>";
				
			//address1
			CusInfo += "<h3>Billing Address</h3>";
			
			CusInfo += "<div class=\"form-group\">";
			CusInfo += "<label for=\"phone1\" class=\"col-sm-2 control-label\">Phone 1</label>";
			CusInfo	+= "<div class=\"col-sm-10\">";
			CusInfo += "<input type=\"text\" class=\"form-control\" id=\"phone1\" placeholder=\"Phone 1\" value=\""+ a1.getPhone()+"\" readonly />";
			CusInfo += "</div>"; 
			CusInfo	+= "</div>";
			
			CusInfo += "<div class=\"form-group\">";
			CusInfo += "<label for=\"address1L1\" class=\"col-sm-2 control-label\">Address Line 1</label>";
			CusInfo	+= "<div class=\"col-sm-10\">";
			CusInfo += "<input type=\"text\" class=\"form-control\" id=\"address1L1\" placeholder=\"Home Address Line 1\" value=\""+ a1.getLine1() +"\" readonly />";
			CusInfo += "</div>";
			CusInfo	+= "</div>";
			
			CusInfo += "<div class=\"form-group\">";
			CusInfo += "<label for=\"address1L2\" class=\"col-sm-2 control-label\">Address Line 2</label>";
			CusInfo	+= "<div class=\"col-sm-10\">";
			CusInfo += "<input type=\"text\" class=\"form-control\" id=\"address1L2\" placeholder=\"Address Line 2\" value=\""+ a1.getLine2() +"\" readonly />";
			CusInfo += "</div>";
			CusInfo	+= "</div>";
			
			CusInfo += "<div class=\"form-group\">";
			CusInfo += "<label for=\"city1\" class=\"col-sm-2 control-label\">City</label>";
			CusInfo	+= "<div class=\"col-sm-10\">";
			CusInfo += "<input type=\"text\" class=\"form-control\" id=\"city1\" placeholder=\"City\" value=\""+ a1.getCity() +"\" readonly />";
			CusInfo += "</div>";
			CusInfo	+= "</div>";
			
			CusInfo += "<div class=\"form-group\">";
			CusInfo += "<label for=\"state1\" class=\"col-sm-2 control-label\">State</label>";
			CusInfo	+= "<div class=\"col-sm-10\">";
			CusInfo += "<input type=\"text\" class=\"form-control\" id=\"state1\" placeholder=\"State\" value=\""+ a1.getState() +"\" readonly />";
			CusInfo += "</div>";
			CusInfo	+= "</div>";
			
			CusInfo += "<div class=\"form-group\">";
			CusInfo += "<label for=\"zip1\" class=\"col-sm-2 control-label\">Zip Code</label>";
			CusInfo	+= "<div class=\"col-sm-10\">";
			CusInfo += "<input type=\"text\" class=\"form-control\" id=\"zip1\" placeholder=\"Zip Code\" value=\""+ a1.getZipCode() +"\" readonly />";
			CusInfo += "</div>";
			CusInfo	+= "</div>";
			
			//address2
			CusInfo += "<h3>Shipping Address</h3>";
			
			CusInfo += "<div class=\"form-group\">";
			CusInfo += "<label for=\"phone2\" class=\"col-sm-2 control-label\">Phone 2</label>";
			CusInfo	+= "<div class=\"col-sm-10\">";
			CusInfo += "<input type=\"text\" class=\"form-control\" id=\"phone2\" placeholder=\"Phone 2\" value=\""+ a2.getPhone()+"\" readonly />";
			CusInfo += "</div>"; 
			CusInfo	+= "</div>";
			
			CusInfo += "<div class=\"form-group\">";
			CusInfo += "<label for=\"address2L1\" class=\"col-sm-2 control-label\">Address Line 1</label>";
			CusInfo	+= "<div class=\"col-sm-10\">";
			CusInfo += "<input type=\"text\" class=\"form-control\" id=\"address2L1\" placeholder=\"Address Line 1\" value=\""+ a2.getLine1() +"\" readonly />";
			CusInfo += "</div>";
			CusInfo	+= "</div>";
			
			CusInfo += "<div class=\"form-group\">";
			CusInfo += "<label for=\"address2L2\" class=\"col-sm-2 control-label\">Address Line 2</label>";
			CusInfo	+= "<div class=\"col-sm-10\">";
			CusInfo += "<input type=\"text\" class=\"form-control\" id=\"address2L2\" placeholder=\"Address Line 2\" value=\""+ a2.getLine2() +"\" readonly />";
			CusInfo += "</div>";
			CusInfo	+= "</div>";
			
			CusInfo += "<div class=\"form-group\">";
			CusInfo += "<label for=\"city2\" class=\"col-sm-2 control-label\">City</label>";
			CusInfo	+= "<div class=\"col-sm-10\">";
			CusInfo += "<input type=\"text\" class=\"form-control\" id=\"city2\" placeholder=\"City\" value=\""+ a2.getCity() +"\" readonly />";
			CusInfo += "</div>";
			CusInfo	+= "</div>";
			
			CusInfo += "<div class=\"form-group\">";
			CusInfo += "<label for=\"state2\" class=\"col-sm-2 control-label\">State</label>";
			CusInfo	+= "<div class=\"col-sm-10\">";
			CusInfo += "<input type=\"text\" class=\"form-control\" id=\"state2\" placeholder=\"State\" value=\""+ a2.getState() +"\" readonly />";
			CusInfo += "</div>";
			CusInfo	+= "</div>";
			
			CusInfo += "<div class=\"form-group\">";
			CusInfo += "<label for=\"zip2\" class=\"col-sm-2 control-label\">Zip Code</label>";
			CusInfo	+= "<div class=\"col-sm-10\">";
			CusInfo += "<input type=\"text\" class=\"form-control\" id=\"zip2\" placeholder=\"Zip Code\" value=\""+ a2.getZipCode() +"\" readonly />";
			CusInfo += "</div>";
			CusInfo	+= "</div>";
			
			//delete
			CusInfo += "<div class=\"form-group\"><div class=\"col-sm-12\">";
			CusInfo += "<button class=\"col-sm-offset-9 col-sm-3 btn btn-default\" type=\"submit\">Delete User</button>";
			CusInfo	+= "</div>";
			CusInfo	+= "</div>";
			
			CusInfo += "</form>";		
			
			request.setAttribute("CusInfo", CusInfo);
		} catch (Exception e){
			request.setAttribute("message", "<div class='alert alert-danger' role='alert'>Error! This isn't the customer you're looking for. " + e + "</div>");
		}
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		try {
			Customer cust = CustomerMC.getOneCustomer(cusId);
			List<Order> orders = cust.getOrders();
			ordInfo += "<h3>Customer Order List</h3>";
			ordInfo += "<table class=\"table table-hover\"><th>Order ID</th><th>Order Date</th><th>Shipping Amount</th>";
			for(int index = 0; index < orders.size(); index++){
				ordInfo += "<tr>";
				ordInfo += "<td><a href='OrderListController?cusID="+ cust.getCustomerId()  +"&ordID="+ index +" '>" + orders.get(index).getOrderId() + "</a></td>";
				ordInfo += "<td>" + orders.get(index).getOrderDate() + "</td>";
				ordInfo += "<td>" + currency.format(orders.get(index).getShipAmount()) +"</td>";
				ordInfo += "</tr>";
			}
			ordInfo += "</table>";		
			
			request.setAttribute("ordInfo", ordInfo);
		} catch (Exception e){
			message += "<div class='alert alert-danger' role='alert'>Error! These aren't the orders you're looking for. " + e + "</div>";
			request.setAttribute("message", message);
		}
		
		
		getServletContext().getRequestDispatcher("/customerView.jsp").forward(request, response);
	}//END doPost
}//END class CustomerController