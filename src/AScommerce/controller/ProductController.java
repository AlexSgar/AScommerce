package AScommerce.controller;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;

import AScommerce.facade.ProductFacade;
import AScommerce.model.Product;
import AScommerce.model.Provider;

@ManagedBean(name = "productController")
public class ProductController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private String code;
	private String description;
	private Float price;
	private Integer quantityAvaiable;
	private Product product;
	private List<Product> products;
	
	@EJB(beanName="productFacade")
	private ProductFacade productFacade;


	
	
	public String createProduct(){
		this.product = this.productFacade.createProduct(name, code, description, price, quantityAvaiable);
		return "product";
	}
	
	public String showProducts(){
		this.products = this.productFacade.getAllProducts();
		return "products";
	}
	
	public String findProduct(){
		this.product = this.productFacade.findProduct(id);
		return "product";
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantityAvaiable() {
		return quantityAvaiable;
	}

	public void setQuantityAvaiable(Integer quantityAvaiable) {
		this.quantityAvaiable = quantityAvaiable;
	}

	public ProductFacade getProductFacade() {
		return productFacade;
	}

	public void setProductFacade(ProductFacade productFacade) {
		this.productFacade = productFacade;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
