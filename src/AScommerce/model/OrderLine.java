package AScommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Float unitPrice;
	
	@Column(nullable = false)
	private Integer quantity;
	
	private Float totale; 

	@Column(nullable = false)
	@ManyToOne
	private Product product;

	public OrderLine(Integer quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
		this.unitPrice = this.product.getPrice();
		this.totale=this.quantity*this.unitPrice;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
