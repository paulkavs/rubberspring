package org.pk.rubberspring;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

	public static void main(String[] args) throws Exception {

		SpringApplication app = new SpringApplication(App.class);
		System.out.println("hello queue");
		
		// natural ordering example of priority queue
		Queue<Integer> integerPriorityQueue = new PriorityQueue<Integer>(7);
		Random rand = new Random();
		for (int i = 0; i < 7; i++) {
			integerPriorityQueue.add(new Integer(rand.nextInt(100)));
		}
		for (int i = 0; i < 7; i++) {
			Integer in = integerPriorityQueue.poll();
			System.out.println("Processing Integer:" + in);
		}

		// PriorityQueue example with Comparator
		Queue<Client> ClientPriorityQueue = new PriorityQueue<Client>(7, idComparator);
		addDataToQueue(ClientPriorityQueue);
		pollDataFromQueue(ClientPriorityQueue);

	}

	// Comparator anonymous class implementation
	public static Comparator<Client> idComparator=new Comparator<Client>(){

	public int compare(Client c1,Client c2){
		return(int)(c1.getId()-c2.getId());
		}
	};

	// utility method to add random data to Queue
	private static void addDataToQueue(Queue<Client> ClientPriorityQueue) {
		Random rand = new Random();
		for (int i = 0; i < 7; i++) {
			int id = rand.nextInt(100);
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