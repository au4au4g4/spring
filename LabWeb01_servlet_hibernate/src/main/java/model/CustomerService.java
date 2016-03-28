package model;

import model.dao.CustomerDAO;

public class CustomerService {
	private static CustomerDAO dao = new CustomerDAO();;
	
	
	
	public CustomerVO select(String custid) {
		return dao.select(custid);
	}
}
