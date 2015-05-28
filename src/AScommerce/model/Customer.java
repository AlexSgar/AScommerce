package AScommerce.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String surname;
	
//	@Temporal(TemporalType.DATE)
//	private Date dateOfBirth;
//	
//	@Temporal(TemporalType.DATE)
//	private Date dateOfRegistration;
	
	@Column(nullable = false)
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private Address address;
	
	@Column(nullable = false)
	private String email;
	
	@OneToMany(mappedBy="customer")
	private Collection<Order> orders;


	public Customer(String name, String surname, Address address, String email) {
		this.name = name;
		this.surname = surname;
//		this.dateOfBirth = dateOfBirth;
//		this.dateOfRegistration = new Date();
		this.address = address;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

//	public Date getDateOfBirth() {
//		return dateOfBirth;
//	}
//
//	public void setDateOfBirth(Date dateOfBirth) {
//		this.dateOfBirth = dateOfBirth;
//	}
//
//	public Date getDateOfRegistration() {
//		return dateOfRegistration;
//	}
//
//	public void setDateOfRegistration(Date dateOfRegistration) {
//		this.dateOfRegistration = dateOfRegistration;
//	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	
	public Collection<Order> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}
	
	

}
