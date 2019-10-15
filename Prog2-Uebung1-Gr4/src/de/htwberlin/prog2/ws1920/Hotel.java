package de.htwberlin.prog2.ws1920;

public class Hotel {
	private String name;
	private Address location;
	private int capacity;
	private Guest guests [];
	
	public Hotel(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}
	
	public boolean addGuest(Guest guest) {
		// ... 
		return true;
	}

	public boolean removeGuest(Guest guest) {
		//...
		
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Guest[] getGuests() {
		return guests;
	}

	public void setGuests(Guest[] guests) {
		this.guests = guests;
	}

	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}
}
