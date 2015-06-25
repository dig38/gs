package modelcontroller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import mytools.DBUtil;
import model.Address;

public class AddressMC {
    public AddressMC() {
        super();
        // TODO Auto-generated constructor stub
    }
	    
    public static void insert(Address addAddress){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		System.out.println("IM HERE:-------------"+ addAddress.getCustomer().getCustomerId() + "-------------!");
		try{
			trans.begin();
			em.persist(addAddress);
			trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}		
	}//END insert
    
	public static void update(Address upAddress){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try{
			trans.begin();
			em.merge(upAddress);
			trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}		
	}//END update
	
	public static long getMaxId(){
		Address addressThis;
		Long getThisId = (long) 0;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();		
		String queryString = "SELECT A FROM Address A "
				+ "WHERE A.addressId = (select max(A.addressId) FROM Address A)";
		TypedQuery<Address> typeQue = em.createQuery(queryString, Address.class);
		
		try{
			addressThis = typeQue.getSingleResult();
			getThisId = addressThis.getAddressId();
			return(getThisId);
		} catch (Exception e)
		{
			System.out.println(e);
			return(-1);
		}finally{
			em.close();
		}
	}//END getMaxId
}//END class AddressMC