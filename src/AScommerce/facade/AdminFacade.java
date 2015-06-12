package AScommerce.facade;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import AScommerce.model.Admin;

@Stateless
public class AdminFacade {
	
	@PersistenceContext(unitName = "unit-jee-AScommerce")
	private EntityManager em;
	
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
