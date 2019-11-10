package de.htwberlin.prog2.ws1920;

public class Fahrrad implements IBuchbar{

	@Override
	public boolean buchen(int day) {

		System.out.println("Fahrrad.buchen() wurde gebucht");
		return false;
	}

}
