package AScommerce.controller;

import javax.ejb.EJB;

import AScommerce.facade.CustomerFacade;
import AScommerce.model.Customer;

public class SessionController {

	@EJB
	private CustomerFacade customerFacade;
	
	private Customer currentCustomer;
	
	//public void setAttribute();
}
