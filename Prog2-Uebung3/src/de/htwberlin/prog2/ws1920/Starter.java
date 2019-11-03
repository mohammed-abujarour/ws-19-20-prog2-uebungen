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
		
		Hotel motelOne = new Hotel("MotelOne", 100, 200);
		motelOne.setLocation(new Address("Invalidenstr.", "67", "10557", "Berlin"));
		motelOne.addGuest(matt);
		motelOne.addGuest(anna);
		
		
		Zimmer zimmer1 = new Einzelzimmer("001");
		Zimmer zimmer2 = new Dopplezimmer("002");
		
		motelOne.addZimmer(zimmer1);
		motelOne.addZimmer(zimmer2);
		
		System.out.println(motelOne);
//		System.out.println(zimmer1);
//		System.out.println(zimmer2);
	}
}
