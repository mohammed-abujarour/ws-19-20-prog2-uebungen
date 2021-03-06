package de.htwberlin.prog2.ws1920;

import java.util.Arrays;

public class Hotel {
	private String name;
	private Address location;
	private int capacity;
	
	private Guest guests [];
	private IBuchbar zimmerList [];
	
	public Hotel(String name, int capacity, int numberOfRooms) {
		this.name = name;
		this.capacity = capacity;
		this.zimmerList = new IBuchbar[numberOfRooms];
	}
	
	
	public boolean addZimmer(IBuchbar zimmer) {
		for(int i = 0; i < zimmerList.length; i++) {
			if(zimmerList[i] == null) {
				zimmerList[i] = zimmer;
			return true;
			}
		}
		
		return false;
	}
	
	public Zimmer suchen(String number) {
		for (IBuchbar buchbar : zimmerList) {
			if(buchbar instanceof Zimmer) {
				Zimmer zimmer = (Zimmer) buchbar;
			if(zimmer.getNumber().equals(number))
				return zimmer;
			}
		}
		return null;
	}
	
	public Zimmer einZimmerBuchen(int day) {
		
		for(IBuchbar zimmer : zimmerList) {
			if(zimmer.buchen (day))
				return (Zimmer) zimmer;
		}
		
		return null;
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


	@Override
	public String toString() {
		return "Hotel [name=" + name + ", location=" + location + ", capacity=" + capacity + ", guests="
				+ Arrays.toString(guests) + ", zimmerList=" + Arrays.toString(zimmerList) + "]";
	}
}
