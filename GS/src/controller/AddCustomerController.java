package controller;

import java.io.IOException;
import java.util.Enumeration;
import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.List;


//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.Customer;
import modelcontroller.AddressMC;
import modelcontroller.CustomerMC;
//import mytools.DBUtil;

/**
 * SERVLET implementation class AddCustomerController
 */
@WebServlet("/AddCustomerController")
public class AddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerController() {
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
		Enumeration<String> addenum = request.getParameterNames();
		String param = new String();
		Customer cust = new Customer();
		Address a1 = new Address(), a2 = new Address();
		long CustId = CustomerMC.getMaxId() + 1, a2Id = AddressMC.getMaxId() + 1, a1Id = a2Id + 1;
		System.out.println("CustId: " + CustId + ". a1Id: " + a1Id + ". a2Id: " + a2Id);
		
		cust.setCustomerId(CustId);
		cust.setPassword("password");
		
		cust.setFirstName(request.getParameter("fname"));
		cust.setLastName(request.getParameter("lname"));
		cust.setEmailAddress(String.valueOf(CustId));
		cust.setBillingAddressId(BigDecimal.valueOf(a1Id));
		cust.setShippingAddressId(BigDecimal.valueOf(a2Id));
		/*
			http://stackoverflow.com/questions/16572207/how-to-save-foreign-key-entity-in-jpa
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		Customer customer = em.getReference(Customer.class, cust.getCustomerId());
		entityManager.persist(newCustomerHistory);
		*/
		
		
		
		
		
		a1.setAddressId(a1Id);
		a1.setCustomer(cust);
		a1.setPhone(request.getParameter("phone1"));
		a1.setLine1(request.getParameter("address1L1"));
		a1.setLine2(request.getParameter("address1L2"));
		a1.setCity(request.getParameter("city1"));
		a1.setState(request.getParameter("state1"));
		a1.setZipCode(request.getParameter("zip1"));
		
		a2.setAddressId(a2Id);
		a2.setCustomer(cust);
		a2.setPhone(request.getParameter("phone2"));
		a2.setLine1(request.getParameter("address2L1"));
		a2.setLine2(request.getParameter("address2L2"));
		a2.setCity(request.getParameter("city2"));
		a2.setState(request.getParameter("state2"));
		a2.setZipCode(request.getParameter("zip2"));
		
		/*
		param = nextPar(addenum ,param, request);
		cust.setFirstName(request.getParameter(param));
		param = nextPar(addenum ,param, request);
		cust.setLastName(request.getParameter(param));
		param = nextPar(addenum ,param, request);
		cust.setEmailAddress(String.valueOf(CustId));
		
		
		//Address Billing
		param = nextPar(addenum ,param, request);
		a1.setPhone(request.getParameter(param));
		param = nextPar(addenum ,param, request);
		a1.setLine1(request.getParameter(param));
		param = nextPar(addenum ,param, request);
		a1.setLine2(request.getParameter(param));
		param = nextPar(addenum ,param, request);
		a1.setCity(request.getParameter(param));
		param = nextPar(addenum ,param, request);
		a1.setState(request.getParameter(param));
		param = nextPar(addenum ,param, request);
		a1.setZipCode(request.getParameter(param));
		
		//Address Shipping
		param = nextPar(addenum ,param, request);
		a2.setPhone(request.getParameter(param));
		param = nextPar(addenum ,param, request);
		a2.setLine1(request.getParameter(param));
		param = nextPar(addenum ,param, request);
		a2.setLine2(request.getParameter(param));
		param = nextPar(addenum ,param, request);
		a2.setCity(request.getParameter(param));
		param = nextPar(addenum ,param, request);
		a2.setState(request.getParameter(param));
		param = nextPar(addenum ,param, request);
		a2.setZipCode(request.getParameter(param));
		*/
		
		//Testing Code
		while(addenum.hasMoreElements())
		{
			param = (String) addenum.nextElement();
			System.out.println(param);
			System.out.println(request.getParameter(param));
		}
		
		
		//Insert Customer
		CustomerMC.insert(cust);
		System.out.print("\nA1: " + a1.getAddressId());
		AddressMC.insert(a1);
		System.out.print("\nA2: " + a2.getAddressId());
		AddressMC.insert(a2);
			
		
		
		//Send Response
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/IndexController");
		rd.forward(request, response);
	}//END doPost
	
	/*
	private String nextPar(Enumeration<String> addenum, String param, HttpServletRequest request){
		param = (String) addenum.nextElement();
		System.out.println(param + ": " + request.getParameter(param) + "\n");
		return (param);
		
	}
	*/
}//END class AddCustomerController