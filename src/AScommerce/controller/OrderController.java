package AScommerce.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import AScommerce.facade.OrderFacade;
import AScommerce.facade.ProductFacade;
import AScommerce.model.Order;
import AScommerce.model.OrderLine;
import AScommerce.model.Product;



@ManagedBean
public class OrderController extends SessionController {
	
	@ManagedProperty(value="#{param.id}")
	private Long idOrder;
	private Long quantity;
	private Order currentOrder;
	
	@EJB
	private OrderFacade orderFacade;
	@EJB
	private ProductFacade productFacade;
	
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
		this.productFacade.updateProductQuantity(p,this.quantity.intValue());
		this.productFacade.updateProduct(p);
		OrderLine ol = new OrderLine(this.quantity.intValue(),p);
		this.currentOrder.addOrderLine(ol);
		return "products";
		
	}
	public String endOrder(){
		this.orderFacade.createOrder(currentOrder);
		this.setSessionAttribute("currentOrder", null);
		return "productsOrdered";
	}
	
	public String showOrders(){
		return "orders";
	}
	
	public String findOrder(){
		this.currentOrder = this.orderFacade.findOrder(idOrder);
		return "productsOrdered";
	}
	
	public List<OrderLine> getOrderLines(){
		return this.currentOrder.getOrderLines();
	}
	
	public List<Order> getAllOrders(){
		return this.orderFacade.getAllOrders(this.getCurrentCustomer().getId());
	}
	
	public boolean isOrderingAProduct(){
		return this.currentOrder!=null;
	}
	
	
	public boolean isOrderingAndCanClose(){
		return this.currentOrder!=null && this.currentOrder.getOrderLines().size()>0;
	}
	
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

}
