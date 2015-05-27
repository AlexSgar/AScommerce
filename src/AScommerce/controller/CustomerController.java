package AScommerce.controller;

import java.util.Collection;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import AScommerce.model.Address;
import AScommerce.model.Customer;
import AScommerce.model.CustomerFacade;
import AScommerce.model.Order;

@ManagedBean
public class CustomerController {
	
	private Long id;
	private Customer customer;
	private String name;
	private String surname;
	private Date dateOfBirth;
	private Date dateOfRegistration;
	private Address address;
	private String email;
	private Collection<Order> orders;
	
	@EJB
	private CustomerFacade customerFacade;

	public String logIn(){
		return "home";
	}
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

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

	public Collection<Order> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}

	
	
}
