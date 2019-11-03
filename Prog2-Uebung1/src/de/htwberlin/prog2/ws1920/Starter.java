package de.htwberlin.prog2.ws1920;

public class Starter {

	public static void main(String[] args) {
		Guest matt = new Guest("Matt");
		matt.setGender(Gender.MALE);
		
		Guest anna = new Guest("Anna");
		anna.setGender(Gender.FEMALE);
		
		Address privateAdresse = new Address("Stephan Str.", "12a", "10559", "Berlin");
		matt.setPrivateAdresse(privateAdresse );
		
		anna.setPrivateAdresse(privateAdresse);
		
		System.out.println(matt);
		System.out.println(anna);
		
		Hotel motelOne = new Hotel("MotelOne", 100);
		motelOne.setLocation(new Address("Invalidenstr.", "67", "10557", "Berlin"));
		motelOne.addGuest(matt);
		motelOne.addGuest(anna);
	}
}
