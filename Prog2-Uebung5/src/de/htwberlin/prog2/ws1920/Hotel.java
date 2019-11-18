package de.htwberlin.prog2.ws1920;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Hotel {
	private String name;
	private Address location;
	private List<IBuchbar> services;

	private List<Reservation> reservations = new ArrayList<>();
	private Map<LocalDate, Set<Reservation>> reservationIndex;

	public Hotel(String name) {
		this.name = name;
		this.services = new ArrayList<>();
		this.reservationIndex = new HashMap<LocalDate, Set<Reservation>>();
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

			this.reservations.add(reservation);
			updateIndex(reservation);
			if (reservation != null)
				return reservation;
		}

		return null;
	}

	private void updateIndex(Reservation reservation) {

		LocalDate key = reservation.getFrom().toLocalDate();
		Set<Reservation> currentReservations = this.reservationIndex.get(key);

		if (currentReservations == null)
			currentReservations = new TreeSet<Reservation>();

		currentReservations.add(reservation);

		this.reservationIndex.put(key, currentReservations);

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

	/**
	 * @return the reservations
	 */
	public List<Reservation> getReservations() {
		return reservations;
	}

	public Set<Reservation> getReservations(LocalDate day) {

		return this.reservationIndex.get(day);
	}

	@Override
	public String toString() {
		return "Hotel [" + (name != null ? "name=" + name + ", " : "")
				+ (location != null ? "location=" + location + ", " : "")
				+ (reservations != null ? "reservations=" + reservations + ", " : "")
				+ (services != null ? "services=" + services : "") + "]";
	}

}
