package de.htwberlin.prog2.ws1920.exc;

import java.util.Arrays;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class InvalidHotelStammdatenException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String source;
	private String[] loadedData;

	/**
	 * @param string
	 * @param hotelStammdaten
	 */
	public InvalidHotelStammdatenException(String source, String[] hotelStammdaten) {
		this.source = source;
		this.loadedData = hotelStammdaten;
	}

	public String toString() {
		return "Source: " + source + " -> Data: " + Arrays.toString(loadedData);
	}

}
