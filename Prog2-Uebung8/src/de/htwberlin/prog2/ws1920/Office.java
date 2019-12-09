package de.htwberlin.prog2.ws1920;

import de.htwberlin.prog2.ws1920.interior.Ausstattung;

public class Office extends Zimmer {

	private static final long serialVersionUID = -5411874013693490565L;

	private Ausstattung ausstattung;

	public Office(String number) {
		super(number);
	}

	/**
	 * @return the ausstattung
	 */
	public Ausstattung getAusstattung() {
		return ausstattung;
	}

	/**
	 * @param ausstattung the ausstattung to set
	 */
	public void setAusstattung(Ausstattung ausstattung) {
		this.ausstattung = ausstattung;
	}

}
