package AScommerce.facade;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import AScommerce.model.Customer;
import AScommerce.model.ImpossibleEvadeOrder;
import AScommerce.model.Order;
import AScommerce.model.OrderLine;
import AScommerce.model.Product;

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
	
	public void updateOrder(Order o){
		em.merge(o);
	}
	
	public List<Order> getAllOrders(Long idCustomer){
		TypedQuery<Order> tq = em.createQuery("SELECT o FROM Orders o WHERE o.customer.id = :id", Order.class);
		tq.setParameter("id", idCustomer);
		return tq.getResultList();
	}

	public List<Order> getAllOrdersClosed() {
		TypedQuery<Order> tq = em.createQuery("SELECT o FROM Orders o WHERE o.fulfilTime IS NULL", Order.class);
		return tq.getResultList();
	}
	
	public void evadeOrder(Order o) throws ImpossibleEvadeOrder{
		String errorMessage = "";
		for(OrderLine ol: o.getOrderLines()){
			Product p = ol.getProduct();
			int nuovaQuantitaDisponibile = p.getQuantityAvaiable()-ol.getQuantity();
			if(nuovaQuantitaDisponibile>=0){
				p.setQuantityAvaiable(nuovaQuantitaDisponibile);
				em.merge(p);
			}
			else errorMessage+="\""+p.getName()+"\""+" ";
		}
		if(!errorMessage.equals(""))
			throw new ImpossibleEvadeOrder(errorMessage);
		o.setFulfilTime(new Date());
		this.updateOrder(o);
	}
	
}
