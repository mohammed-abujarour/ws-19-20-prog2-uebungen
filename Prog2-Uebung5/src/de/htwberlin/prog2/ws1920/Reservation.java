package de.htwberlin.prog2.ws1920;

public class Reservation {
	
	private IBuchbar bookedItem;
	private String notes;
	private String from;
	private String to;
	private Guest guest;
	
	
	public Reservation(IBuchbar bookedItem, Guest guest, String from, String to) {
		this.bookedItem = bookedItem;
		this.setGuest(guest);
		this.from = from;
		this.to = to;
	}

	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public IBuchbar getBookedItem() {
		return bookedItem;
	}


	public String getFrom() {
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
		if(guest != null)
			this.guest = guest;
	}

	@Override
	public String toString() {
		return "Reservation [bookedItem=" + bookedItem + ", notes=" + notes + ", from=" + from + ", to=" + to + "]";
	}
	
	
	
}
