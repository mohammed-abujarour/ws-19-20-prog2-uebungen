package de.htwberlin.prog2.ws1920;

import java.util.Date;

import de.htwberlin.prog2.ws1920.extern.Wallet;

public class Guest implements Comparable<Guest>{

	private String firstName;
	private String lastName;
	private Gender gender;
	private Date birthDate;
	private Address privateAdresse;
	private Address businessAdresse;
	private Wallet<IBuchbar> bookingHistory;
	private Wallet<Payment> paymentHistory;
	private long id;
	private long points = 0;
	private static long counter = 100;

	public Guest(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = counter++;
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

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the points
	 */
	public long getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void addPoints(long points) {
		this.points += points;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(". ");

		if (firstName != null) {
			builder.append(firstName);
			builder.append(" ");
		}
		if (lastName != null) {
			builder.append(lastName);
			builder.append(", ");
		}
	
		builder.append(points);
		builder.append(" points");

		return builder.toString();
	}

	@Override
	public int compareTo(Guest o) {

		return Long.compare(this.id, o.getId());
	}



}
