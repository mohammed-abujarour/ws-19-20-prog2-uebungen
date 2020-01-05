package de.htwberlin.prog2.ws1920;

import java.time.LocalDateTime;

public interface IBuchbar {

	public Reservation buchen(LocalDateTime from, LocalDateTime to, Guest guest);

	public String getNummer();
	
	public double getPrice();
}
