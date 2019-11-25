package de.htwberlin.prog2.ws1920;

import java.time.LocalDateTime;

public class Dopplezimmer extends Zimmer implements IBuchbar {

	private static final long serialVersionUID = -8934089493984389461L;
	private boolean seperatedBeds;

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
		return super.toString() + " seperatedBeds= " + seperatedBeds;
	}

	@Override
	public Reservation buchen(LocalDateTime from, LocalDateTime to, Guest guest) {

		return null;
	}

	@Override
	public String getNummer() {
		return super.getNumber();
	}

}
