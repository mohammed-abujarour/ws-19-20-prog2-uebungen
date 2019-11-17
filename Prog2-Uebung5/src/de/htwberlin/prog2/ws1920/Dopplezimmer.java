package de.htwberlin.prog2.ws1920;

import java.time.LocalDateTime;

public class Dopplezimmer extends Zimmer implements IBuchbar {

	private boolean seperatedBeds ;
	
	public Dopplezimmer(String number) {
		super(number);
	}

	public boolean isSeperatedBeds() {
		return seperatedBeds;
	}

	public void setSeperatedBeds(boolean seperatedBeds) {
		this.seperatedBeds = seperatedBeds;
	}

	@Override
	public String toString() {
		return  super.toString() + " seperatedBeds= " + seperatedBeds ;
	}

	@Override
	public boolean buchen(LocalDateTime from, LocalDateTime to) {

		return false;
	}

	

}
