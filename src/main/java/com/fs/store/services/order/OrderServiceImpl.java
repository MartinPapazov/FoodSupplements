package com.fs.store.services.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.store.dao.order.OrderDao;
import com.fs.store.dao.product.ProductDao;
import com.fs.store.entities.Order;
import com.fs.store.entities.Status;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao dao;
	
	@Override
	public List<Order> getAllOrders() {
		return this.dao.getAllOrders();
	}

	@Override
	public Order getOrderById(int id) {
		return this.dao.getOrderById(id);
	}

	@Override
	public boolean addOrder(Order order) {
		return this.dao.addOrder(order);
	}

	@Override
	public boolean changeOrder(Order order) {
		return this.dao.changeOrder(order);
	}

	@Override
	public boolean deleteOrder(Order order) {
		return this.dao.deleteOrder(order);
	}

	@Override
	public boolean acceptOrder(Order order) {
		return this.dao.acceptOrder(order);
	}

	@Override
	public boolean finishOrder(Order order) {
		return this.dao.finishOrder(order);
	}

	@Override
	public boolean deniedOrder(Order order) {
		return this.dao.deniedOrder(order);
	}

	@Override
	public boolean orderStatusChanged(Status status) {
		return this.dao.orderStatusChanged(status);
	}

}
