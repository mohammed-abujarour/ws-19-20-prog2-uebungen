package de.htwberlin.prog2.ws1920.interior;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class OfficeEinrichter implements Einrichter {

	public Tisch createTisch() {
		return new Konferenztisch();
	}

	public Stuhl[] createStuhle() {
		Stuhl stuehle [] = new Stuhl[] {new Konferenzstuhl(), new Konferenzstuhl(), new Konferenzstuhl()};
		return stuehle;
	}

	public Schrank createSchrank() {
		return new Bueroschrank();
	}

}
