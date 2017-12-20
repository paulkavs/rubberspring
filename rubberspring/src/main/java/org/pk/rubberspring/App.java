package org.pk.rubberspring;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner{
	
	public static Queue<Order> clientPriorityQueue=null;

	public static void main(String[] args) throws Exception {

		SpringApplication app = new SpringApplication(App.class);
		System.out.println("hello queue");

		// PriorityQueue example with Comparator
		clientPriorityQueue = new PriorityQueue<Order>(new ClientComparator());
		addDataToQueue(clientPriorityQueue);
		pollDataFromQueue(clientPriorityQueue);

	}

	// utility method to add random data to Queue
	private static void addDataToQueue(Queue<Order> ClientPriorityQueue) {
		Random rand = new Random();
		for (int i = 0; i < 70; i++) {
			int id = rand.nextInt(20000);
			int quantity = rand.nextInt(20);
			LocalDateTime timestamp = LocalDateTime.now();
			ClientPriorityQueue.add(new Order(id, quantity, timestamp));
		}
	}

	// utility method to poll data from queue
	private static void pollDataFromQueue(Queue<Order> ClientPriorityQueue) {
		while (true) {
			Order order = ClientPriorityQueue.poll();
			if (order == null)
				break;
			System.out.println("Processing Order with ClientId=" + order.getClientId() + " quantity=" + order.getQuantity()+ " time spent in queue="+ Duration.between(LocalDateTime.now(),order.getTimestamp())
			);
		}
	}

	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	
}
