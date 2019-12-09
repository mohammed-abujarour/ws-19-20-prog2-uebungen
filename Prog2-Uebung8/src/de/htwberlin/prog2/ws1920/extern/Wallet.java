package de.htwberlin.prog2.ws1920.extern;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Wallet<T> implements Serializable {

	private static final long serialVersionUID = 1138663106282343826L;
	private List<T> items = new ArrayList<>();

	public boolean store(T item) {
		return items.add(item);
	}

	public List<T> retrieveItems() {
		return this.items;
	}
}
