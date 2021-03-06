package AScommerce.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date closedTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fulfilTime;
	
	@Column(nullable = false)
	@ManyToOne
	private Customer customer;
	
	@OneToMany(fetch=FetchType.EAGER,cascade ={CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="order_id")
	private List<OrderLine> orderLines;

	private Float totale; 
	
	

	public Order(Customer customer) {
		this.creationTime = new Date();
		this.customer = customer;
		this.orderLines = new LinkedList<OrderLine>();
	}
	
	public void setTotaleOrdine(){
		Float tot=new Float(0);
		for(OrderLine o : this.orderLines){
			tot+=o.getTotale();
		}
		this.totale = tot;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getClosedTime() {
		return closedTime;
	}

	public void setClosedTime(Date closedTime) {
		this.closedTime = closedTime;
	}

	public Date getFulfilTime() {
		return fulfilTime;
	}

	public void setFulfilTime(Date fulfilTime) {
		this.fulfilTime = fulfilTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	public void addOrderLine(OrderLine ol){
		this.orderLines.add(ol);
	}

	public Long getId() {
		return id;
	}
	
	public Float getTotale() {
		return totale;
	}

	public void setTotale(Float totale) {
		this.totale = totale;
	}
	
}
