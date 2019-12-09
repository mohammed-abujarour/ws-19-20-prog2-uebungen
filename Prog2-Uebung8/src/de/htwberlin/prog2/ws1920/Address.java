package de.htwberlin.prog2.ws1920;

import java.io.Serializable;

public class Address implements Serializable {

	// TEIL 1/3

	private static final long serialVersionUID = 6281334797615630438L;
	private String strasse;
	private String hausNr;
	private String plz;
	private String stadt;

	// TEIL 2/3
	public Address(String strasse, String hausNr, String plz, String stadt) {
		this.strasse = strasse;
		this.hausNr = hausNr;
		this.plz = plz;
		this.stadt = stadt;
	}
	// TEIL 3/3

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausNr() {
		return hausNr;
	}

	public void setHausNr(String hausNr) {
		this.hausNr = hausNr;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	@Override
	public String toString() {
		return "Address [strasse=" + strasse + ", hausNr=" + hausNr + ", plz=" + plz + ", stadt=" + stadt + "]";
	}

}
