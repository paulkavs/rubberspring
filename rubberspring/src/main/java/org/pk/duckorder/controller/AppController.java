package org.pk.duckorder.controller;

import java.util.List;
import org.pk.duckorder.Order;
import org.pk.duckorder.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController implements RestOrderService {

	@Autowired
	OrderServiceImpl orderService;

	@RequestMapping(value = "/createOrder/", method = RequestMethod.POST)
	public String createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}

	@RequestMapping(value = "/getOrderDetails/{clientId}", method = RequestMethod.GET)
	public String getOrderDetails(@PathVariable("clientId") int clientId) {
		return orderService.getOrderDetails(clientId);
	}

	@RequestMapping(value = "/cancelOrder/{clientId}", method = RequestMethod.DELETE)
	public String cancelOrder(@PathVariable("clientId") int clientId) {
		return orderService.cancelOrder(clientId);
	}

	@RequestMapping(value = "/getAllOrders/", method = RequestMethod.GET)
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@RequestMapping(value = "/getNextDelivery/", method = RequestMethod.GET)
	public List<Order> getNextDelivery() {
		return orderService.getNextDelivery();
	}

}