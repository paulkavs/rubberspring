# rubberspring
order system

Run the Project

Import project into an Eclipse workspace
Run src\main\java\org\pk\duckorder\App.java as a Java Application

In a REst Client (DHC/Postman)

	/**
	 * The POST create order operation for client
	 */
	@POST
	String createOrder(Order order);

	/**
	 * The GET order position and wait time by Client id operation for client
	 */
	@GET
	@Path("/{id}")
	String getOrderDetails(@PathParam("id") int clientId);

	/**
	 * The DELETE cancel order operation for client
	 */
	@DELETE
	@Path("/{id}")
	String cancelOrder(@PathParam("id") int clientId); 

	/**
	 * The GET all orders operation for manager
	 */
	@GET
	List<Order> getAllOrders();

	/**
	 * The GET next delivery operation for Joe
	 */
	@GET
	List<Order> getNextDelivery();


	