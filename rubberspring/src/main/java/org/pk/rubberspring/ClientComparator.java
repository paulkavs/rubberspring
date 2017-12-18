package org.pk.rubberspring;

import java.util.Comparator;

public class ClientComparator implements Comparator<Client> {

	public ClientComparator() {
		// TODO Auto-generated constructor stub
	}

	public int compare(Client o1, Client o2) {
		if (o1.getId() <= 1000 && o2.getId() <= 1000)
			return Integer.compare(o1.getId(), o2.getId());
		if (o1.getId() > 1000 && o2.getId() > 1000)
			return Integer.compare(o1.getId(), o2.getId());
		if (o1.getId() <= 1000 && o2.getId() > 1000)
			return -1;
		return 1;
	}

}
