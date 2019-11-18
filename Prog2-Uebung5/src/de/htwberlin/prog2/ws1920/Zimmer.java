package de.htwberlin.prog2.ws1920;

public abstract class Zimmer {

	private String number;
	private double price;
	private int capacity;

	public Zimmer(String number) {
		this.number = number;

	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Zimmer [number=" + number + ", price=" + price + ", capacity=" + capacity + "]";
	}

}
