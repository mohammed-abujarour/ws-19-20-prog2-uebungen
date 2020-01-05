package de.htwberlin.prog2.ws1920;

import java.time.LocalDateTime;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public abstract class Service implements IBuchbar {

   private IBuchbar zimmer;
   
   public Service(IBuchbar zimmer) {
       this.zimmer = zimmer;
   }
   
   public IBuchbar getZimmer() {
       return this.zimmer;
   }

   

}
