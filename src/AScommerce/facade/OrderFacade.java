package AScommerce.facade;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import AScommerce.model.Customer;
import AScommerce.model.Order;

@Stateless
public class OrderFacade {

	@PersistenceContext(unitName = "unit-jee-AScommerce")
	private EntityManager em;
	
	public Order createOrder(Order order){
		em.persist(order);
		return order;
	}
	
	public Order findOrder(Long id){
		return em.find(Order.class, id);
	}
	
	public List<Order> getAllOrders(Long idCustomer){
		TypedQuery<Order> tq = em.createQuery("SELECT o FROM Orders o WHERE o.customer.id = :id", Order.class);
		tq.setParameter("id", idCustomer);
		return tq.getResultList();
	}
	
}
