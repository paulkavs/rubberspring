package org.pk.rubberspring;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner{

	public static void main(String[] args) throws Exception {

		SpringApplication app = new SpringApplication(App.class);
		System.out.println("hello queue");

		// PriorityQueue example with Comparator
		Queue<Client> ClientPriorityQueue = new PriorityQueue<Client>(new ClientComparator());
		addDataToQueue(ClientPriorityQueue);
		pollDataFromQueue(ClientPriorityQueue);

	}

	// utility method to add random data to Queue
	private static void addDataToQueue(Queue<Client> ClientPriorityQueue) {
		Random rand = new Random();
		for (int i = 0; i < 70; i++) {
			int id = rand.nextInt(20000);
			ClientPriorityQueue.add(new Client(id));
		}
	}

	// utility method to poll data from queue
	private static void pollDataFromQueue(Queue<Client> ClientPriorityQueue) {
		while (true) {
			Client client = ClientPriorityQueue.poll();
			if (client == null)
				break;
			System.out.println("Processing Client with ID=" + client.getId());
		}
	}

	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	
}
