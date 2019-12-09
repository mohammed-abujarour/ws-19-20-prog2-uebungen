package de.htwberlin.prog2.ws1920.interior;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class SuiteEinrichter implements Einrichter {

	public Tisch createTisch() {
		return new Esstisch();
	}

	public Stuhl[] createStuhle() {
		Stuhl stuehle[] = new Stuhl[] { new Esszimmerstuhl(), new Esszimmerstuhl(), new Esszimmerstuhl(),
				new Esszimmerstuhl() };
		return stuehle;
	}

	public Schrank createSchrank() {
		return new LuxusKleiderschrank();
	}

}
