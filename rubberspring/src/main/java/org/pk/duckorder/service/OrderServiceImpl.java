package org.pk.duckorder.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.pk.duckorder.OrderSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.pk.duckorder.Cart;
import org.pk.duckorder.Order;
import org.springframework.stereotype.Component;

@Component("orderService")
public class OrderServiceImpl implements OrderService {
	
	private static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

	/*
	 * ArrayList with comparator used for the RubberDuck order queue to allow
	 * for sorting while retaining ability to search by index
	 */
	public List<Order> orders = new ArrayList<Order>();
	OrderSort orderSorter = new OrderSort();

	public Cart cart = Cart.getInstance();

	public OrderServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getOrderDetails(int orderId) {
		String position = ("order with client ID: " + orderId + " is at position: " + orders.indexOf(orderId)
				+ " in a queue of " + orders.size() + " orders.");
		Order order = orders.get(orders.indexOf(orderId));
		int orderQuantity = order.getQuantity();
		String waitTime = getWaitTime(orders.indexOf(orderId), orderQuantity);
		return position+waitTime;
	}

	/*Calculate the total waiting period for this order to be fulfilled assuming max orderQuantity<=25
	  1. Calculate modulus for this order (orderQuantity%cart capacity) 
	  2. Add total quantity in orders ahead of this client's order
	  3. Divide total from 2. above by 25(cart capacity)
	  4. If result from 3. above <1 then return 5 minutes
	  5. Get remainder modulus from 2. above % 25
	  6. If remainder from 5. above is >result of 1. above then return  ((even number from 3. above) x 5 minutes) 
	  7. If remainder from 5. above is <result of 1. above then return ((even number from 3. above+1) x 5 minutes)*/ 
	
	private String getWaitTime(int orderPosition, int orderQuantity) {
		int cartCapacity =25;
		//1.
		double orderModulus = orderQuantity%cartCapacity;
		//2.
		int totalAheadOfOrder = 0;
		for(int i=orderPosition-1; i>=0; i--){
			Order order = orders.get(orderPosition);
			int orderQuant = order.getQuantity();
			totalAheadOfOrder+=orderQuant;
		}
		//3.
		int roundNumber = totalAheadOfOrder/cartCapacity;
		//4.
		if(roundNumber==0){
			return " Wait time approx. 5 minutes for order to be fulfilled";
		}
		int totalModulus = totalAheadOfOrder%cartCapacity;
		int remainderModulus=cartCapacity-totalModulus;
		//5.
		if(orderModulus>remainderModulus){
			return " Wait time approx.: "+ ((roundNumber*5)+5) +" minutes for order to be fulfilled";
		}
		//6.
		if(orderModulus<remainderModulus){
			return " Wait time approx.: "+ (roundNumber*5) +" minutes for order to be fulfilled";
		}
		return null;
	}

	@Override
	public String createOrder(Order order) {
		orders.add(order);
		// re-order queue after every insertion
		Collections.sort(orders, orderSorter);
		return "Order with ClientID: "+order.getClientId()+" created and added to queue";
	}

	@Override
	public String cancelOrder(int clientId) {
		for (Order order : orders) {
			if (order.getClientId() == clientId) {
				orders.remove(order);
				return "cancelled order with client ID: " + clientId;
			}
		}
		return "order with clientID: " + clientId + " could not be found in order queue";
	}

	@Override
	public List<Order> getAllOrders() {
		return orders;
	}

	@Override
	public boolean removeOrder() {
		if (orders != null && orders.size() > 0) {
			Order order = orders.get(0);
			int orderQuantity = order.getQuantity();
			int spareCapacity = cart.getCapacity() - cart.getItemCount();
			if (orderQuantity <= spareCapacity) {
				log.info("removing order: " + orders.get(0).toString() + "from queue and adding to cart");
				cart.addToCart(order);
				orders.remove(0);
				return true;
			} else if (orderQuantity > spareCapacity) {
				log.info("cart is full, please wait till next turn");
				return false;
			}
		}
		log.info("nothing left in order queue to remove");
		return false;
	}

	/*this method should be called every 5 minutes by Joe using the /getNextDelivery REST api
	1. fill cart with orders from queue
	2. return cart contents to Joe
	3. empty cart for next delivery*/
	@Override
	public List<Order> getNextDelivery() {
		while(removeOrder()==true){
			removeOrder();
		}
		List<Order> orders = cart.getOrders();
		cart.setItemCount(0);
		cart.setOrders(null);
		return orders;
	}

}
