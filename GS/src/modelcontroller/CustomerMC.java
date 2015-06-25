package modelcontroller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import mytools.DBUtil;
import model.Customer;

public class CustomerMC {
    public CustomerMC() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	public static void insert(Customer cust){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		//cust.setCustomerId(getMaxId() + 1);
		
		try{
			trans.begin();
			em.persist(cust);
			trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}		
	}//END insert
	public static void update(Customer cust){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try{
			trans.begin();
			em.merge(cust);
			trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}		
	}//END update
	public static void delete(Customer cust){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try{
			trans.begin();
			em.remove(em.merge(cust));
			trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}		
	}//END delete
	public static List<Customer> getAllCustomers(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Customer> customerList = null;
		String queryString = "SELECT C FROM Customer C";
		TypedQuery<Customer> typeQue = em.createQuery(queryString, Customer.class);
		try{
			customerList = typeQue.getResultList();
			if(customerList == null || customerList.isEmpty())
				customerList = null;
			return customerList;
		}finally{
			em.close();
		}
	}//END getAllCustomers
	
	public static Customer getOneCustomer(String cusId){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		Customer customer = null;
		String queryString = "SELECT C FROM Customer C "
				+ "WHERE C.customerId = :custId ";
		TypedQuery<Customer> typeQue = em.createQuery(queryString, Customer.class);
		Long tempLong = Long.parseLong(cusId);
		typeQue.setParameter("custId", tempLong.longValue());
		try{
			customer = typeQue.getSingleResult();
			return customer;
		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}finally{
			em.close();
		}
	}//END getOneCustomer
	
	public static long getMaxId(){
		Long getThisId = (long)0;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();		
		String queryString = "SELECT C FROM Customer C "
				+ "WHERE C.customerId = (select max(C.customerId) FROM Customer C)";
		TypedQuery<Customer> typeQue = em.createQuery(queryString, Customer.class);
		
		try{
			Customer cust = typeQue.getSingleResult();
			getThisId = cust.getCustomerId();
			System.out.println("Customer max ID" +getThisId);
			return getThisId;
		} catch (Exception e) {
			System.out.println(e);
			return(-1);
		}finally{
			em.close();
		}
	}//END getMaxId
	
}//END class CustomerMC