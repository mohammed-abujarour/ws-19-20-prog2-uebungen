package de.htwberlin.prog2.ws1920;

import java.time.LocalDateTime;
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

	public boolean addService(IBuchbar zimmer) {

		return services.add(zimmer);
	}

	public Zimmer suchen(String number) {
		for (IBuchbar buchbar : services) {
			if (buchbar instanceof Zimmer) {
				Zimmer zimmer = (Zimmer) buchbar;
				if (zimmer.getNumber().equals(number))
					return zimmer;
			}
		}
		return null;
	}

	public Reservation einZimmerBuchen(LocalDateTime from, LocalDateTime to, Guest guest) {

		for (IBuchbar service : services) {
			if (!(service instanceof Zimmer))
				continue;
			Reservation reservation = service.buchen(from, to, guest);
			if (reservation != null)
				return reservation;
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

	public List<Reservation> getReservations() {
		return null;
	}

	@Override
	public String toString() {
		return "Hotel [" + (name != null ? "name=" + name + ", " : "")
				+ (location != null ? "location=" + location + ", " : "")
				+ (services != null ? "services=" + services : "") + "]";
	}



}
