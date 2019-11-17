package de.htwberlin.prog2.ws1920;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private String name;
	private Address location;
	
	private List<IBuchbar> services;
	
	public Hotel(String name) {
		this.name = name;
		this.services = new ArrayList<>();
	}
	
	
	public boolean addZimmer(IBuchbar zimmer) {
		
		return services.add(zimmer);
	}
	
	public Zimmer suchen(String number) {
		for (IBuchbar buchbar : services) {
			if(buchbar instanceof Zimmer) {
				Zimmer zimmer = (Zimmer) buchbar;
			if(zimmer.getNumber().equals(number))
				return zimmer;
			}
		}
		return null;
	}
	
	public Zimmer einZimmerBuchen(int day) {
		
		for(IBuchbar zimmer : services) {
			if(zimmer.buchen (day))
				return (Zimmer) zimmer;
		}
		
		return null;
	}
	



	public String getName() {
		return name;
	}

	

	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "Hotel [name=" + name + ", location=" + location 
				 + ", zimmerList=" + services + "]";
	}
}
