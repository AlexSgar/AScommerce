package AScommerce.facade;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

	
}
