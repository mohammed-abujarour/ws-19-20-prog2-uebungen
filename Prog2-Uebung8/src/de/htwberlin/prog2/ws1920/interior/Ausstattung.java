package de.htwberlin.prog2.ws1920.interior;

import java.util.Arrays;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class Ausstattung {
	private Tisch tisch;
	private Stuhl [] stuehle;
	private Schrank schrank;
	
	public Ausstattung(Tisch tisch, Stuhl [] stuehle, Schrank schrank) {
		this.tisch = tisch;
		this.stuehle = stuehle.clone();
		this.schrank = schrank;
	}

	// ... 

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ausstattung [");
		if (this.tisch != null) {
			builder.append("tisch=");
			builder.append(this.tisch);
			builder.append(", ");
		}
		if (this.stuehle != null) {
			builder.append("stuehle=");
			builder.append(Arrays.toString(this.stuehle));
			builder.append(", ");
		}
		if (this.schrank != null) {
			builder.append("schrank=");
			builder.append(this.schrank);
		}
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
