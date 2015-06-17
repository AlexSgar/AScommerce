package AScommerce.facade;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import AScommerce.model.Address;
import AScommerce.model.Customer;

@Stateless
public class CustomerFacade {
	
	@PersistenceContext(unitName = "unit-jee-AScommerce")
	private EntityManager em;
	
	
	public Customer signUp(String name, String surname, String password,String email,Date dateOfBirth,Address address){
		Customer c = new Customer(name, surname,password,email, dateOfBirth, address);
		em.persist(c);
		return c;
	}
	
	public Customer findCustomer(Long id){
		return em.find(Customer.class, id);
	}
	
	public boolean existsCustomer(String email){
	    Customer c = this.findCustomer(email);
	    return c!=null;
	}
	
	public Customer findCustomer(String email){
		TypedQuery<Customer> q = em.createQuery("SELECT c FROM Customer c WHERE c.email= :email", Customer.class);
		q.setParameter("email", email);
		try{
			return q.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
	}
}
