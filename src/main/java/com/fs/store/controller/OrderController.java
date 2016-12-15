package com.fs.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fs.store.constants.UrlConstants;
import com.fs.store.entities.Order;
import com.fs.store.services.order.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService service;
	
	@RequestMapping(value = UrlConstants.ALL_ORDERS, method = RequestMethod.GET)
	public @ResponseBody List<Order> getAllOrders() {
		return service.getAllOrders();
	}
	
	@RequestMapping(value = UrlConstants.ORDER_BY_ID, method = RequestMethod.POST)
	public @ResponseBody Order getOrderById(@RequestBody Order order) {
		return service.getOrderById(order.getId());
	}
}
