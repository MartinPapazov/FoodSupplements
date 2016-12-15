package com.fs.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String cusotmerProfile( Model model) {
		return "customer/profile";
	}

}
