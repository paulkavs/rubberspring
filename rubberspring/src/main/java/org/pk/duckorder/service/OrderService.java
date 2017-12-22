package org.pk.duckorder.service;

import java.util.List;

import org.pk.duckorder.Order;

public interface OrderService {

	String getOrderDetails(int orderId);

	List<Order> getAllOrders();

	String createOrder(Order order);

	String cancelOrder(int clientID);
	
	boolean removeOrder();
	
	List<Order> getNextDelivery();
	

}
