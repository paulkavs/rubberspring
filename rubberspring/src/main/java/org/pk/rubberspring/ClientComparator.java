package org.pk.rubberspring;

import java.util.Comparator;

public class ClientComparator implements Comparator<Order> {

	public ClientComparator() {
		// TODO Auto-generated constructor stub
	}

	public int compare(Order o1, Order o2) {
		if (o1.getClientId() <= 1000 && o2.getClientId() <= 1000)
			return Integer.compare(o1.getClientId(), o2.getClientId());
		if (o1.getClientId() > 1000 && o2.getClientId() > 1000)
			return Integer.compare(o1.getClientId(), o2.getClientId());
		if (o1.getClientId() <= 1000 && o2.getClientId() > 1000)
			return -1;
		return 1;
	}

}
