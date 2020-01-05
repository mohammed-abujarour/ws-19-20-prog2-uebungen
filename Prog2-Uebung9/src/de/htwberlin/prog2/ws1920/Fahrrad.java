package de.htwberlin.prog2.ws1920;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Fahrrad extends Service implements Serializable {

	private static final long serialVersionUID = 6962095595313604535L;
	private String id;

	public Fahrrad(IBuchbar zimmer, String id) {
	    super(zimmer);
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

    public double getPrice() {
        return getZimmer().getPrice() + 3.5;
    }

}
