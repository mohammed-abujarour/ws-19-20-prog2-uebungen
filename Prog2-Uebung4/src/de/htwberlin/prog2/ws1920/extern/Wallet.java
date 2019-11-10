package de.htwberlin.prog2.ws1920.extern;

import java.util.ArrayList;
import java.util.List;

public class Wallet <T>{

	
	private List<T> items = new ArrayList<>();
	
	public boolean store(T item) {
		return items.add(item);
	}

	public List<T> retrieveItems(){
		return this.items;
	}
}
