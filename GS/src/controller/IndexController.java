package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import modelcontroller.CustomerMC;
/**
 * SERVLET implementation class Index
 */
@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
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
		String tableInfo = "";
		String flag = "1";
		request.setAttribute("flag", flag);
		
		try {
			List<Customer> customerList = CustomerMC.getAllCustomers();
			
			tableInfo += "<table class=\"table table-hover\"><th>Name</th><th>ID</th><th>Email</th>";
			for(int index = 0; index < customerList.size(); index++){
				tableInfo += "<tr>";
				tableInfo += "<td><a href='CustomerController?cusID=" + customerList.get(index).getCustomerId()+"'>" + customerList.get(index).getFirstName() + " " + customerList.get(index).getLastName() + "</a></td>";
				//System.out.print(customerList.get(index).getCustomerId());
				tableInfo += "<td>" + customerList.get(index).getCustomerId() + "</td>";
				tableInfo += "<td>" + customerList.get(index).getEmailAddress() +"</td>";
				tableInfo += "</tr>";	
			}
			tableInfo += "</table>";		
			
			request.setAttribute("tableInfo", tableInfo);
		} catch (Exception e){
			//"Product List not found"
			request.setAttribute("message", "<div class='alert alert-danger' role='alert'>Error! These aren't the customers you're looking for. " + e + "</div>");
		}
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}//END doPost
}//END class Index