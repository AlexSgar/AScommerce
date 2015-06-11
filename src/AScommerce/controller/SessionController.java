package AScommerce.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import AScommerce.facade.CustomerFacade;
import AScommerce.model.Customer;

public class SessionController {


	private Customer currentCustomer;
	
	@PostConstruct
	public void init(){
		this.currentCustomer = (Customer) getSessionAttribute("currentCustomer");
		
	}
	
	public void setSessionAttribute(String value,Object o){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute(value, o);
	}
	
	public Object getSessionAttribute(String value){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		return session.getAttribute(value);
	}
	
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}
	
	public void setCurrentCustomer(Customer currentUser) {
		this.setSessionAttribute("currentCustomer", currentUser);
		this.currentCustomer = currentUser;
	}
	
	
	public boolean isLogged(){
		return this.currentCustomer!=null;
	}
}
