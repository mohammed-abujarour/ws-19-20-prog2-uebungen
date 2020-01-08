package de.htwberlin.prog2.ws1920;

import java.time.LocalDateTime;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class Transfer extends Service {

    private String ziel;
    /**
     * @param zimmer
     */
    public Transfer(IBuchbar zimmer, String ziel) {
        super(zimmer);
        this.ziel = ziel;
    }

    public Reservation buchen(LocalDateTime from, LocalDateTime to, Guest guest) {
        // TODO Auto-generated method stub
        return null;
    }

    public double getPrice() {
        return getZimmer().getPrice() + 35;
    }
    
    public String toString() {
        return "Transfer nach " + ziel;
    }

    public String getNummer() {
        return null;
    }

}
