package AScommerce.controller;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import AScommerce.model.Admin;
import AScommerce.model.Customer;

public class SessionController {


	private Customer currentCustomer;
	private Admin currentAdmin;
	
	@PostConstruct
	public void init(){
		this.currentCustomer = (Customer) getSessionAttribute("currentCustomer");
		this.currentAdmin = (Admin) getSessionAttribute("currentAdmin");
		
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
	public void removeAttribute(String nameAttribute){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.removeAttribute(nameAttribute);
	}
	
	public void invalidateSession(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.invalidate();
		this.currentAdmin=null;
		this.currentCustomer=null;
	}
	
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}
	
	public void setCurrentCustomer(Customer currentUser) {
		this.setSessionAttribute("currentCustomer", currentUser);
		this.currentCustomer = currentUser;
	}
	
	public void setCurrentAdmin(Admin a){
		this.setSessionAttribute("currentAdmin", a);
		this.currentAdmin = a;
	}
	
	public boolean isCustomerLogged(){
		return this.currentCustomer!=null;
	}
	public boolean isAdminLogged(){
		return this.currentAdmin!=null;
	}
	
	public boolean isNotThereAUser(){
		return this.currentAdmin==null && this.currentCustomer==null;
	}
}
