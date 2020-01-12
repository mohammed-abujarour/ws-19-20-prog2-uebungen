package com.awesomeui.hotel;

import de.htwberlin.prog2.ws1920.Backend;
import de.htwberlin.prog2.ws1920.Hotel;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class Starter {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Hotel hotel = Backend.getHotel();
        
        MainFrame mainFrame = new MainFrame(hotel.getName());
        
        mainFrame.setVisible(true);

    }

}
