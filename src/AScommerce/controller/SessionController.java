package AScommerce.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import AScommerce.facade.CustomerFacade;
import AScommerce.model.Customer;

public class SessionController {

	@EJB
	private CustomerFacade customerFacade;
	
	

	private Customer currentCustomer;
	
	@PostConstruct
	public void init(){
		Long idUser = (Long) getSessionAttribute("currentCustomer");
		if (idUser != null){
			this.currentCustomer = this.customerFacade.findCustomer(idUser);
		}
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
		this.setSessionAttribute("currentCustomer", currentUser.getId());
		this.currentCustomer = currentUser;
	}
	
	public CustomerFacade getCustomerFacade() {
		return customerFacade;
	}
	
}
