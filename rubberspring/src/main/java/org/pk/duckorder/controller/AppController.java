package org.pk.duckorder.controller;

import java.net.URI;
import java.util.List;
import org.pk.duckorder.Order;
import org.pk.duckorder.service.OrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class AppController implements RestOrderService {

	private static Logger log = LoggerFactory.getLogger(AppController.class);
	
	@Autowired
	OrderServiceImpl orderService;

	@PostMapping("/createOrder/")
	public ResponseEntity<Void> createOrder(@RequestBody Order order) {
		String response = orderService.createOrder(order);
		
		if (response == null)
			return ResponseEntity.noContent().build();
		log.info(response);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/getOrderDetails/{id}").buildAndExpand(order.getClientId()).toUri();
		return  ResponseEntity.created(location).build();
	}

	@GetMapping("/getOrderDetails/{clientId}")
	public String getOrderDetails(@PathVariable("clientId") int clientId) {
		return orderService.getOrderDetails(clientId);
	}

	@RequestMapping(value = "/cancelOrder/{clientId}", method = RequestMethod.DELETE)
	public String cancelOrder(@PathVariable("clientId") int clientId) {
		return orderService.cancelOrder(clientId);
	}

	@GetMapping("/getAllOrders/")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping("/getNextDelivery/")
	public List<Order> getNextDelivery() {
		return orderService.getNextDelivery();
	}

}