package de.htwberlin.prog2.ws1920;

import java.util.Comparator;

public class GuestComparator implements Comparator<Guest> {

	@Override
	public int compare(Guest g1, Guest g2) {

		int comparePoints = -1 * Long.compare(g1.getPoints(), g2.getPoints());
		int compareLastName = g1.getLastName().compareTo(g2.getLastName());
		if (comparePoints == 0)
			return compareLastName;
		else
			return comparePoints;
	}

}
