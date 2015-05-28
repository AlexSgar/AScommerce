package AScommerce.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;

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
	private String dateOfBirth;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private String email;
	private Collection<Order> orders;
	
	@EJB
	private CustomerFacade customerFacade;

	public String signUp(){
//		try {
//			Date dateOfBirth = new SimpleDateFormat("gg-mm-aaaa").parse(this.dateOfBirth);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		this.customer = this.customerFacade.findCustomer(email);
		if (this.customer==null)
			this.customer = this.customerFacade.signUp(name, surname, new Address(street, city, state, zipcode, country), email);
		return "home";
	}
	
	
	//getter e setter
	
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	
	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public CustomerFacade getCustomerFacade() {
		return customerFacade;
	}


	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
	}
	
	
}
