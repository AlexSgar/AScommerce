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
	private Long idProduct;
	private Long quantity;
	private Order currentOrder;
	
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
		return "productsOrdered";
	}
	
	public List<OrderLine> getOrderLines(){
		return (List<OrderLine>) this.currentOrder.getOrderLines();
	}
	
	public boolean isOrderingAProduct(){
		return this.currentOrder!=null;
	}
	
	public boolean isOrderingAndCanClose(){
		return this.currentOrder!=null && this.currentOrder.getOrderLines().size()>0;
	}
	
	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
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
