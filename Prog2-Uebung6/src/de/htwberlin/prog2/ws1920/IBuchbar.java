package de.htwberlin.prog2.ws1920;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface IBuchbar extends Serializable {

	public Reservation buchen(LocalDateTime from, LocalDateTime to, Guest guest);

	public String getNummer();
}
