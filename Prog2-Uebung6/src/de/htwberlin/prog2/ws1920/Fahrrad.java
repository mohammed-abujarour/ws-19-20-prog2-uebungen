package de.htwberlin.prog2.ws1920;

import java.time.LocalDateTime;

public class Fahrrad implements IBuchbar {

	private String id;

	public Fahrrad(String id) {
		this.id = id;
	}

	@Override
	public Reservation buchen(LocalDateTime from, LocalDateTime to, Guest guest) {

		System.out.println("Fahrrad.buchen() wurde von " + from + " bis " + to + "gebucht");
		return null;
	}

	@Override
	public String getNummer() {
		return id;
	}

}
