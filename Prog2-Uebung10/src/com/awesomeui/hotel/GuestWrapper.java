package com.awesomeui.hotel;

import java.util.Date;

import de.htwberlin.prog2.ws1920.Address;
import de.htwberlin.prog2.ws1920.Guest;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class GuestWrapper {
    private Guest guest;
    private NameFormatStrategy nameFormatStrategy;

    public GuestWrapper(Guest guest) {
        this.guest = guest;
        nameFormatStrategy = new FirstNameLastName();
    }

    public void setNameFormatStrategy(NameFormatStrategy strategy) {
        this.nameFormatStrategy = strategy;
    }

    public String toString() {
//        return guest.getFirstName() + " " + guest.getLastName();
        return nameFormatStrategy.display(guest);
    }

    public Date getBirthDate() {
        return guest.getBirthDate();
    }

    public Address getPrivateAdresse() {
        return guest.getPrivateAdresse();
    }

}
