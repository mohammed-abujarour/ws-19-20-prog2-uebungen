package com.awesomeui.hotel;

import java.util.List;

import de.htwberlin.prog2.ws1920.Guest;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class Utils {

    /**
     * @param guests
     * @return
     */
    public static GuestWrapper[] buildGuestWrappers(List<Guest> guests) {

        GuestWrapper guestWrappers [] = new GuestWrapper[guests.size()];
        for(int i =0; i<guestWrappers.length; i++) {
            guestWrappers[i] = new GuestWrapper(guests.get(i));
        }
        return guestWrappers;
    }

}
