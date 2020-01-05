package de.htwberlin.prog2.ws1920;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Einzelzimmer extends Zimmer implements IBuchbar {

	private static final long serialVersionUID = -6413597070561933073L;
	private List<Reservation> reservations = new ArrayList<>();

	public Einzelzimmer(String number) {
		super(number);
		super.setCapacity(1);
		super.setPrice(50);
	}

	@Override
	public Reservation buchen(LocalDateTime from, LocalDateTime to, Guest guest) {

		if (!isAvailable(from, to))
			return null;
		Reservation newReservation = null;
		try {
			newReservation = new Reservation(this, guest, from, to);
			this.reservations.add(newReservation);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return newReservation;
	}

	private boolean isAvailable(LocalDateTime from, LocalDateTime to) {
		return true;
	}

	@Override
	public String getNummer() {
		return super.getNumber();
	}

}
