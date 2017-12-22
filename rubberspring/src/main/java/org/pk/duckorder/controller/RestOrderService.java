package org.pk.duckorder.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.pk.duckorder.Order;

/**
 * A JAX-RS Resource interface where we define the RESTful web service, using
 * the JAX-RS annotations.
 * <p/>
 * When using cxfrs with Camel then this resource class can be an interface, as
 * its just a contract/facade to describe the REST web service. When a client
 * calls the REST services then its a Camel route that routes the incoming
 * request, see {@link OrderRoute} <br/>
 * This REST service supports both xml and json as data format.
 */
@Path("/orders/")
@Consumes(value = "application/xml,application/json")
@Produces(value = "application/xml,application/json")
public interface RestOrderService {

	/**
	 * The GET order position and wait time by Client id operation for client
	 */
	@GET
	@Path("/{id}")
	String getOrderDetails(@PathParam("id") int clientId);

	/**
	 * The GET all orders operation for manager
	 */
	@GET
	List<Order> getAllOrders();

	/**
	 * The GET cart contents operation for Joe
	 */
	@GET
	List<Order> getNextDelivery();

	/**
	 * The POST create order operation for client
	 */
	@POST
	String createOrder(Order order);

	/**
	 * The DELETE cancel order operation for client
	 */
	@DELETE
	@Path("/{id}")
	String cancelOrder(@PathParam("id") int clientId);

}