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
    
    public GuestWrapper(Guest guest) {
        this.guest = guest;
    }
    
    public String toString() {
        return guest.getFirstName() + " " + guest.getLastName();
    }
    
    public Date getBirthDate() {
        return guest.getBirthDate();
    }
    
    public Address getPrivateAdresse() {
        return guest.getPrivateAdresse();
    }

}
