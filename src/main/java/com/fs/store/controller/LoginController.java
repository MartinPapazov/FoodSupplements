package com.fs.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fs.store.entities.Customer;
import com.fs.store.services.customer.CustomerService;

@Controller
public class LoginController {
	
	@Autowired
	private CustomerService custService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login/login";
		
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signInPage() {
		return "login/signin";
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute(value="customer")Customer customer
//			@RequestParam("password_repeat") String passwordRepeat,
			){

		boolean isCreated = custService.addUser(customer);
		
		if (!isCreated) {
			//TODO: return error massage
		}
		return "login/login";
	}
}
