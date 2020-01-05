package de.htwberlin.prog2.ws1920;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.bookings.hotel.BookingsReservatation;
import com.bookings.hotel.api.Webservice;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class PartnerHotelAdapter implements IHotel{

    public Reservation einZimmerBuchen(LocalDateTime from, LocalDateTime to, Guest guest) {

        System.out.println("PartnerHotelAdapter.einZimmerBuchen()");
        Date fromDate =  Date.from(from.atZone(ZoneId.systemDefault()).toInstant());
        Date toDate =         Date.from(to.atZone(ZoneId.systemDefault()).toInstant());

        BookingsReservatation externReservierung = Webservice.buchen(guest.getFirstName(), guest.getLastName(), fromDate, toDate);
        System.out.println(externReservierung);
        
        Reservation resrvierung = null;
        try {
            resrvierung = new Reservation(null, guest, from, to);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    
        return resrvierung;
    }

}
