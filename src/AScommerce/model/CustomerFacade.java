package AScommerce.model;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CustomerFacade {
	
	@PersistenceContext(unitName = "unit-jee-AScommerce")
	private EntityManager em;
	
	
	public Customer signUp(String name, String surname, Date dateOfBirth, Address address, String email){
		Customer c = new Customer(name, surname, dateOfBirth, address, email);
		em.persist(c);
		return c;
	}
	
	public Customer findCustomer(Long id){
		return em.find(Customer.class, id);
	}
	
	public Customer findCustomer(String email){
		TypedQuery<Customer> q = em.createQuery("SELECT c FROM Customer c WHERE c.email= :email", Customer.class);
		q.setParameter("email", email);
		return q.getSingleResult();
	}
}
