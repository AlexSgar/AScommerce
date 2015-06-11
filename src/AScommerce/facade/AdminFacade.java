package AScommerce.facade;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import AScommerce.model.Address;
import AScommerce.model.Admin;

@Stateless
public class AdminFacade {
	
	@PersistenceContext(unitName = "unit-jee-AScommerce")
	private EntityManager em;
	
	
	public Admin signUp(String name, String surname, String password,String email,Date dateOfBirth,Address address){
		Admin c = new Admin(name, surname,password,email, dateOfBirth, address);
		em.persist(c);
		return c;
	}
	
	public Admin findAdmin(Long id){
		return em.find(Admin.class, id);
	}
	
	public boolean existsAdmin(String email){
	    Admin c = this.findAdmin(email);
	    return c!=null;
	}
	
	public Admin findAdmin(String email){
		TypedQuery<Admin> q = em.createQuery("SELECT a FROM Admin a WHERE a.email= :email", Admin.class);
		q.setParameter("email", email);
		try{
			return q.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
	}
}
