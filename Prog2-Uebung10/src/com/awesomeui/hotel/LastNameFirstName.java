package com.awesomeui.hotel;

import de.htwberlin.prog2.ws1920.Guest;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class LastNameFirstName implements NameFormatStrategy {

    public String display(Guest guest) {
        return guest.getLastName() + ", " + guest.getFirstName();
    }

}
