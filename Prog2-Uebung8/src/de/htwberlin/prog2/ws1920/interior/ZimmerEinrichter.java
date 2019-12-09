package de.htwberlin.prog2.ws1920.interior;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class ZimmerEinrichter implements Einrichter {

	public Tisch createTisch() {
		return new Schreibtisch();
	}

	public Stuhl[] createStuhle() {
		Stuhl stuehle [] = new Stuhl[] {new Schreibtischstuhl(), new Schreibtischstuhl()};
		return stuehle;
	}

	public Schrank createSchrank() {
		return new Kleiderschrank();
	}

}
