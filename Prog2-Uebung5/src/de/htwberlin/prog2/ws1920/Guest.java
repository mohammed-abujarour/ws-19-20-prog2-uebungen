package de.htwberlin.prog2.ws1920;

import java.util.Date;

import de.htwberlin.prog2.ws1920.extern.Wallet;

public class Guest {
	
	private String name;
	private Gender gender;
	private Date birthDate;
	private Address privateAdresse;
	private Address businessAdresse;
	private Wallet<IBuchbar> bookingHistory;
	private Wallet<Payment> paymentHistory;
	
	public Guest(String name) {
		this.name = name;
		bookingHistory = new Wallet<>();
		paymentHistory = new Wallet<>();
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


	/**
	 * @return the bookingHistory
	 */
	public Wallet<IBuchbar> getBookingHistory() {
		return bookingHistory;
	}

	public String toString() {
		return "Guest [name=" + name + ", privateAdresse=" + privateAdresse + ", businessAdresse=" + businessAdresse
				+ "]";
	}


	

	
}
