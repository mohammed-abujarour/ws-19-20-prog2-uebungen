package de.htwberlin.prog2.ws1920;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Reservation implements Comparable<Reservation>, Serializable {

	private static final long serialVersionUID = -3378665643393130226L;
	private IBuchbar bookedItem;
	private String notes;
	private LocalDateTime from;
	private LocalDateTime to;
	private Guest guest;

	public Reservation(IBuchbar bookedItem, Guest guest, LocalDateTime from, LocalDateTime to) throws Exception {
		this.bookedItem = bookedItem;
		this.from = from;
		this.to = to;
		if (from.isAfter(to))
			throw new Exception("Invalid Input - " + from + " must be before " + to);

		if (guest == null)
			throw new Exception("Invlid Input - Guest cannot be null");
		this.setGuest(guest);

	}

	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}


	public LocalDateTime getTo() {
		return to;
	}

	public void setTo(LocalDateTime to) {
		this.to = to;
	}

	public IBuchbar getBookedItem() {
		return bookedItem;
	}

	public LocalDateTime getFrom() {
		return from;
	}

	/**
	 * @return the guest
	 */
	public Guest getGuest() {
		return guest;
	}

	/**
	 * @param guest the guest to set
	 */
	public void setGuest(Guest guest) {
		if (guest == null)
			return;
		this.guest = guest;
		long newPoints = Duration.between(from, to).toDays();
		this.guest.addPoints(newPoints);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (bookedItem != null) {
			builder.append(bookedItem.getNummer());
			builder.append(", ");
		}

		if (from != null) {
			builder.append("[");
			builder.append(
					from.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.GERMAN)));
			builder.append(" - ");
		}
		if (to != null) {
			builder.append(
					to.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.GERMAN)));
			builder.append("] ");
		}
		if (guest != null) {
			builder.append(guest.getFirstName() + " " + guest.getLastName());
		}

		if (notes != null) {
			builder.append(", ");
			builder.append(notes);
		}
		
		return builder.toString();
	}

	@Override
	public int compareTo(Reservation o) {

		return this.guest.getLastName().compareTo(o.getGuest().getLastName());
	}

}
