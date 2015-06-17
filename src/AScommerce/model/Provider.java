package AScommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@NamedQuery(name="findAllProviders", query= "SELECT p FROM Provider WHERE p.products= :id")
@Entity
public class Provider {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String phoneNumber;

	private String email;

	@Column(nullable = false)
	private String vatin;

	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Address address;

	@ManyToMany
	private List<Product> products;

	public Provider(){}

	public Provider(String name, String phoneNumber, String email, String vatin){
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.email=email;
		this.vatin=vatin;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVatin() {
		return vatin;
	}

	public void setVatin(String vatin) {
		this.vatin = vatin;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addProduct(Product product){
		if (this.products == null){
			this.products = new ArrayList<Product>();
		}

		this.products.add(product);
	}
}
