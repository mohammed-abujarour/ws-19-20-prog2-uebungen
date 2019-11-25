/**
 * 
 */
package de.htwberlin.prog2.ws1920;

import de.htwberlin.prog2.ws1920.extern.Wallet;

/**
 * @author abujarour
 *
 */
public class Util {

	public <T> Wallet<T> createWallet(T item) {

		Wallet<T> wallet = new Wallet<>();
		wallet.store(item);
		return wallet;
	}

	public <T> Wallet<T> createWallet(T item1, T item2) {

		Wallet<T> wallet = new Wallet<>();
		wallet.store(item1);
		wallet.store(item2);
		return wallet;

	}
}
