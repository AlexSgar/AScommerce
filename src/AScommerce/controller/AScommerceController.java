package AScommerce.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import AScommerce.facade.CustomerFacade;
import AScommerce.model.Address;
import AScommerce.model.Customer;
import AScommerce.model.InvalidPasswordException;
import AScommerce.model.Order;

@ManagedBean
public class AScommerceController extends SessionController{
	
	private String name;
	private String surname;
	private String password;
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
		Date cdateOfBirth;
		try {
			cdateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(this.dateOfBirth);
			if(this.customerFacade.existsCustomer(email))
				return "error";
			else
				this.setCurrentCustomer(this.customerFacade.signUp(name, surname,password,email,cdateOfBirth, new Address(street, city, state, zipcode, country)));
			
		} catch (ParseException e) {
			return "signUp";
		}
		return "home";
	}
	
	public String logIn(){
		String nextPage = "home";
		Customer c = this.customerFacade.findCustomer(email);
		if(c !=null)
			try{
				c.checkPassword(password);
				this.setCurrentCustomer(c);
			}
			catch(InvalidPasswordException e){
				 nextPage = "error";
			}
		else 
			nextPage = "error";
		return nextPage;
	}
	
	
	//getter e setter


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
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
