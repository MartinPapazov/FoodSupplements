package com.fs.store.services.order;

import java.util.List;

import com.fs.store.entities.Order;
import com.fs.store.entities.Status;

public interface OrderService {

	List<Order> getAllOrders();

	Order getOrderById(int id);

	boolean addOrder(Order order);

	boolean changeOrder(Order order);

	boolean deleteOrder(Order order);

	boolean acceptOrder(Order order);

	boolean finishOrder(Order order);

	boolean deniedOrder(Order order);

	boolean orderStatusChanged(Status status);
}
