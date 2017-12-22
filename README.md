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
	url: localhost:8080/api/createOrder
	Body:
	e.g. { "clientId":1234, "quantity":3 }

	/**
	 * The GET order position and wait time by Client id operation for client
	 */
	@GET
	url: http://localhost:8080/api/getOrderDetails/{clientId}
	e.g. http://localhost:8080/api/getOrderDetails/1234;

	/**
	 * The DELETE cancel order operation for client
	 */
	@DELETE
	url: http://localhost:8080/api/cancelOrder/clientId 
	e.g. http://localhost:8080/api/cancelOrder/1234 

	/**
	 * The GET all orders operation for manager
	 */
	@GET
	url: http://localhost:8080/api/getAllOrders

	/**
	 * The GET next delivery operation for Joe
	 * this method should be called every 5 minutes by Joe 
	@GET
	url: http://localhost:8080/api/getNextDelivery/


	