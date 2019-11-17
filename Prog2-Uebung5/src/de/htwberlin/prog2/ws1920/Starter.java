package de.htwberlin.prog2.ws1920;

import java.time.LocalDateTime;

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
		
		Hotel motelOne = new Hotel("MotelOne");
		motelOne.setLocation(new Address("Invalidenstr.", "67", "10557", "Berlin"));
		
		
		Einzelzimmer zimmer1 = new Einzelzimmer("001");
		Zimmer zimmer2 = new Dopplezimmer("002");
		
		motelOne.addService(zimmer1);
		//motelOne.addZimmer(zimmer2); //geht nicht
		
		System.out.println(motelOne);
		
		Office office = new Office("off-123");
		//office.buchen(20); //geht nicht
		
		zimmer1.buchen(LocalDateTime.now(), LocalDateTime.now().plusDays(3));
		
		Fahrrad bike1 = new Fahrrad();
		bike1.buchen(LocalDateTime.now(), LocalDateTime.now().plusHours(4));
	}
	
	public double checkout(IBuchbar [] buchungen) {
		
		double summe = 0;
		for(IBuchbar buchbar: buchungen)
			summe += 1; // buchbar.getPreis();
		return summe;
	}
}
