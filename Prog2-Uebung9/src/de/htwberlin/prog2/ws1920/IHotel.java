package de.htwberlin.prog2.ws1920;

import java.time.LocalDateTime;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public interface IHotel {
    public Reservation einZimmerBuchen(LocalDateTime from, LocalDateTime to, Guest guest) ;

}
