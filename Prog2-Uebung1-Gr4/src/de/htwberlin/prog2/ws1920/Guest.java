package de.htwberlin.prog2.ws1920;

import java.util.Date;

public class Guest {
	
	private String name;
	private Gender gender;
	private Date birthDate;
	private Address privateAdresse;
	private Address businessAdresse;
	private Reservation reservations [];
	
	public Guest(String name) {
		this.name = name;
		this.reservations = new Reservation[5];
	}
	
	public void setPrivateAdresse(Address privateAdresse) {
		this.privateAdresse = privateAdresse;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Reservation[] getReervations() {
		return this.reservations;
	}
	
	public String toString() {
		return "Guest [name=" + name + ", privateAdresse=" + privateAdresse + ", businessAdresse=" + businessAdresse
				+ "]";
	}


	

	
}
