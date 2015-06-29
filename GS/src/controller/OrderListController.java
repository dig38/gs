package controller;

import java.io.IOException;
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
		String cusId = request.getParameter("cusID");
		//System.out.println(cusId);
		String orderId = request.getParameter("ordID");
		//System.out.println(orderId);
		String title = "Order Items";
		Customer cust;
		try {
			cust = CustomerMC.getOneCustomer(cusId);
			request.setAttribute("cust", cust);
		} catch (Exception e){
			request.setAttribute("message", "<div class='alert alert-danger' role='alert'>Error! This isn't the customer you're looking for. " + e + "</div>");
		}
		
		try {
			cust = CustomerMC.getOneCustomer(cusId);
			Order ord = cust.getOrders().get(Integer.parseInt(orderId));
			List<OrderItem> orderItems = ord.getOrderItems(); 
			request.setAttribute("orderItems", orderItems);
		} catch (Exception e){
			request.setAttribute("message", "<div class='alert alert-danger' role='alert'>Error! These aren't the orders you're looking for. " + e + "</div>");
		}
		
		request.setAttribute("orderflag", true);
		request.setAttribute("title", title);
		getServletContext().getRequestDispatcher("/customerView.jsp").forward(request, response);
	}//END doPost
}//END class OrderListController
