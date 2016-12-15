package com.fs.store.dao.user;

import java.util.List;

import com.fs.store.entities.Customer;

public interface UserDao {

	Customer getUser(String username);
	
	List<Customer> getUsers(String username, String status);

	boolean createUser(Customer customer);
	
	boolean updateCustomer(Customer customer);
}
