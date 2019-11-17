package de.htwberlin.prog2.ws1920;

import java.time.LocalDateTime;

public interface IBuchbar {

	public boolean buchen(LocalDateTime from, LocalDateTime to);
}
