package de.htwberlin.prog2.ws1920;

import java.time.LocalDateTime;

public class Einzelzimmer extends Zimmer implements IBuchbar {
	private boolean[] bookings = new boolean[365];

	public Einzelzimmer(String number) {
		super(number);
		super.setCapacity(1);
	}

	@Override
	public boolean buchen(LocalDateTime from, LocalDateTime to) {
		
		return false;
	
	}

}
