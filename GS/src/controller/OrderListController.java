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
import model.Order;
import model.OrderItem;
import modelcontroller.CustomerMC;
/**
 * SERVLET implementation class OrderListController
 */
@WebServlet("/OrderListController")
public class OrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListController() {
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
		String CusInfo = "", ordInfo = "";
		String custId = request.getParameter("cusID");
		System.out.println(custId);
		String orderId = request.getParameter("ordID");
		String title = "Order Items";
		request.setAttribute("title", title);
		
		try {
			Customer cust = CustomerMC.getOneCustomer(custId);
			CusInfo += "<h2>Customer</h2>";
			
			CusInfo += "<form class=\"form-horizontal\">";
			
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
			
			CusInfo += "</form>";		
			
			request.setAttribute("CusInfo", CusInfo);
		} catch (Exception e){
			request.setAttribute("message", "<div class='alert alert-danger' role='alert'>Error! This isn't the customer you're looking for. " + e + "</div>");
		}
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		try {
			Customer cust = CustomerMC.getOneCustomer(custId);
			Order orders = cust.getOrders().get(Integer.parseInt(orderId));
			List<OrderItem> orderItems = orders.getOrderItems(); 
			ordInfo += "<h3>Order Items List</h3>";
			ordInfo += "<table class=\"table table-hover\">";
			ordInfo += "<th>ID</th>";
			ordInfo += "<th>Product</th>";
			ordInfo += "<th>Quantity</th>";
			ordInfo += "<th>Discount Amount</th>";
			
			for(int index = 0; index < orders.getOrderItems().size(); index++){
				ordInfo += "<tr>";
				ordInfo += "<td>" + orderItems.get(index).getItemId() + "</td>";
				ordInfo += "<td>" + orderItems.get(index).getProduct().getProductName() + "</td>";
				ordInfo += "<td>" + orderItems.get(index).getQuantity() + "</td>";
				ordInfo += "<td>" + currency.format(orderItems.get(index).getDiscountAmount()) +"</td>";
				ordInfo += "</tr>";
			}
			ordInfo += "</table>";		
			
			request.setAttribute("ordInfo", ordInfo);
		} catch (Exception e){
			request.setAttribute("message", "<div class='alert alert-danger' role='alert'>Error! These aren't the orders you're looking for. " + e + "</div>");
		}
		
		
		getServletContext().getRequestDispatcher("/customerView.jsp").forward(request, response);
	}//END doPost
}//END class OrderListController
