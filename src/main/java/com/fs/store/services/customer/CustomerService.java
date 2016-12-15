package com.fs.store.services.customer;

import java.util.List;

import com.fs.store.entities.Customer;

public interface CustomerService {

	Customer getCustomer(String username);
	
	List<Customer> getCustomers(String username, String status);

	boolean addUser(Customer customer);
	
	boolean updateCustomer(Customer customer);
}
