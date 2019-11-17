package de.htwberlin.prog2.ws1920;

public class Reservation {
	
	private IBuchbar bookedItem;
	private String notes;
	private String from;
	private String to;
	
	
	public Reservation(IBuchbar bookedItem, String from, String to) {
		this.bookedItem = bookedItem;
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

	@Override
	public String toString() {
		return "Reservation [bookedItem=" + bookedItem + ", notes=" + notes + ", from=" + from + ", to=" + to + "]";
	}
	
	
	
}
