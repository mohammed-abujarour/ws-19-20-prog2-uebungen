package de.htwberlin.prog2.ws1920;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Hotel implements Serializable {

	private static final long serialVersionUID = -9078931012057164649L;
	private String name;
	private Address location;
	private List<IBuchbar> services;
	private LocalDate openedAt;

	private List<Reservation> reservations = new ArrayList<>();
	private Map<LocalDate, Set<Reservation>> reservationIndex;
	private Set<Guest> guests;

	public Hotel(String name) {
		this.name = name;
		this.services = new ArrayList<>();
		this.reservationIndex = new HashMap<LocalDate, Set<Reservation>>();
		this.guests = new HashSet<>();
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

			if (reservation != null) {
				// reservation.setNotes("Booked through Hotel Management System at " + new
				// Date());
				this.reservations.add(reservation);
				updateIndex(reservation);
				this.guests.add(reservation.getGuest());
				return reservation;
			}
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

	public Set<Guest> getGuests() {
		return this.guests;
	}

	/**
	 * 
	 * @return top 10% Kunden laut ihren Points
	 */
	public List<Guest> getLoyalKunden() {

		List<Guest> copy = new ArrayList<>(this.guests);
		Collections.sort(copy, new Comparator<Guest>() {
			public int compare(Guest g1, Guest g2) {
				return -1 * Long.compare(g1.getPoints(), g2.getPoints());
			}
		});

		int toIndex = (int) Math.ceil(copy.size() * 0.1);
		return copy.subList(0, toIndex);

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
		return "Hotel [" + (name != null ? name + " since " + openedAt + ", " : "")
				+ (location != null ? "location=" + location + ", " : "")
				+ (reservations != null ? "reservations=" + reservations + ", " : "")
				+ (services != null ? "services=" + services : "") + "]";
	}

}
