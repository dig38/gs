package controller;

import java.io.IOException;
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
		String	message = "", 
				cusId = request.getParameter("cusID"),
				title = "Customer Information"; 
		Customer cust = CustomerMC.getOneCustomer(cusId);
		//Customer Info
		try {
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
			
		} catch (Exception e){
			message = "<div class='alert alert-danger' role='alert'>Error! This isn't the customer you're looking for. " + e + "</div>";
			request.setAttribute("message", message);
		}
		//Order Info
		try {
			List<Order> orders = cust.getOrders();
			request.setAttribute("orders", orders);	
		} catch (Exception e){
			message = "<div class='alert alert-danger' role='alert'>Error! These aren't the orders you're looking for. " + e + "</div>";
			request.setAttribute("message", message);
		}
		request.setAttribute("custflag", true);
		request.setAttribute("title", title);
		request.setAttribute("cust", cust);
		request.setAttribute("a1", a1);
		request.setAttribute("a2", a2);
		getServletContext().getRequestDispatcher("/customerView.jsp").forward(request, response);
	}//END doPost
}//END class CustomerController