package de.htwberlin.prog2.ws1920;

public class Einzelzimmer extends Zimmer implements IBuchbar {
	private boolean[] bookings = new boolean[365];

	public Einzelzimmer(String number) {
		super(number);
		super.setCapacity(1);
	}

	@Override
	public boolean buchen(int day) {
		
		if(bookings[day] == true) {
			return false;
		}
		else {
			bookings[day] = true;
			return true;
		}
	
	}

}
