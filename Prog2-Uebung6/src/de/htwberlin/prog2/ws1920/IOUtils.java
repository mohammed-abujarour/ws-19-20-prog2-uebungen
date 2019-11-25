package de.htwberlin.prog2.ws1920;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class IOUtils {
	
	public static boolean  exportHotelObject(Hotel hotel) {
		
		boolean success = false;
		
		String fileName = hotel.getName() + "-" + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		fileName += ".ser";
		System.out.println(fileName);
		ObjectOutputStream oos = null;
		
		File exportFolder = new File("data");
		boolean structureCreated = exportFolder.exists() && exportFolder.isDirectory();

		if(!structureCreated)
			structureCreated = exportFolder.mkdirs();
		if(structureCreated)
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File(exportFolder, fileName)));
			oos.writeObject(hotel);
			oos.flush();
			
			success = true;
		} catch (IOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getLocalizedMessage());
		}
		finally {
			if(oos!=null)
				try {
					oos.close();
				} catch (IOException exc) {
					exc.printStackTrace();
				}
		}
				
		return success;
	}

}
