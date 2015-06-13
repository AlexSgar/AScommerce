package AScommerce.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import AScommerce.facade.OrderFacade;
import AScommerce.model.ImpossibleEvadeOrder;
import AScommerce.model.Order;
import AScommerce.model.OrderLine;
import AScommerce.model.Product;



@ManagedBean
public class OrderController extends SessionController {
	
	@ManagedProperty(value="#{param.id}")
	private Long idOrder;
	private Long quantity;
	private Order currentOrder;
	private String message;
	
	

	@EJB
	private OrderFacade orderFacade;
	
	@PostConstruct
	public void initOrderController(){
		this.init();
		this.currentOrder = (Order) this.getSessionAttribute("currentOrder");
		
	}
	
	public String initOrder(){
		Order newOrder = new Order(this.getCurrentCustomer());
		this.setSessionAttribute("currentOrder",newOrder);
		return "products";
	}
	
	public String addProduct(){
		Product p = (Product) this.getSessionAttribute("currentProduct");
		OrderLine ol = new OrderLine(this.quantity.intValue(),p);
		this.currentOrder.addOrderLine(ol);
		return "products";
		
	}
	public String endOrder(){
		this.orderFacade.createOrder(currentOrder);
		this.currentOrder.setClosedTime(new Date());
		this.removeAttribute("currentOrder");
		this.removeAttribute("currentProduct");
		return "productsOrdered";
	}
	
	public String cancelOrder(){
		this.removeAttribute("currentOrder");
		this.removeAttribute("currentProduct");
		return "home";
	}
	
	public String evadeOrder(){
		try {
			this.orderFacade.evadeOrder(this.currentOrder);
			this.message = "Ordine Evaso correttamente";
		}
		catch(ImpossibleEvadeOrder e ){
			this.message = "Impossibile evadere l'ordine,la quantita di \n"+e.getMessage()+"\n non e' disponbile";
		}
		this.removeAttribute("currentOrder");
		return "productsOrdered";
	}
	
	public String findOrder(){
		this.currentOrder = this.orderFacade.findOrder(idOrder);
		return "productsOrdered";
	}
	
	public String findOrderToEvade(){
		this.currentOrder = this.orderFacade.findOrder(idOrder);
		this.setSessionAttribute("currentOrder", this.currentOrder);
		return "productsOrdered";
	}
	
	public String retrieveCustomerInfo(){
		this.currentOrder = this.orderFacade.findOrder(idOrder);
		return "customerInfo";
	}
	
	
	public List<Order> getAllOrders(){
		return this.orderFacade.getAllOrders(this.getCurrentCustomer().getId());
	}
	
	public List<Order> getAllOrdersClosed(){
		return this.orderFacade.getAllOrdersClosed();
	}
	
	public boolean isCustomerOrderingAProduct(){
		return this.getCurrentCustomer()!=null && this.currentOrder!=null;
	}
	
	
	public boolean isCustomerOrderingAndCanClose(){
		return this.getCurrentCustomer()!=null &&
				this.currentOrder!=null &&
				this.currentOrder.getOrderLines().size()>0;
	}
	
	
	//getter e setter
	
	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Order getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}
	public String getInfoOrdine() {
		return message;
	}

	public void setInfoOrdine(String infoOrdine) {
		this.message = infoOrdine;
	}
}
