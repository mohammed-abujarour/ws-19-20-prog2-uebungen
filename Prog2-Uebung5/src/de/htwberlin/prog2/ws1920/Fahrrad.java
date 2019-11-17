package de.htwberlin.prog2.ws1920;

import java.time.LocalDateTime;

public class Fahrrad implements IBuchbar {

	@Override
	public boolean buchen(LocalDateTime from, LocalDateTime to) {

		System.out.println("Fahrrad.buchen() wurde von " + from + " bis " + to + "gebucht");
		return true;
	}

}
