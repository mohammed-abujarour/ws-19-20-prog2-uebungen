package de.htwberlin.prog2.ws1920;

public class Starter {

	public static void main(String[] args) {
		Guest matt = new Guest("Matt");
		
		Guest anna = new Guest("Anna");
		
		Address privateAdresse = new Address("Stephan Str.", "12a", "10559", "Berlin");
		matt.setPrivateAdresse(privateAdresse );
		
		anna.setPrivateAdresse(privateAdresse);
		
		System.out.println(matt);
		System.out.println(anna);
	}
}
