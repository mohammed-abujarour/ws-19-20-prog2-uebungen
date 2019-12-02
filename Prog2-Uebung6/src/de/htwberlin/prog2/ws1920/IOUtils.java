package de.htwberlin.prog2.ws1920;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class IOUtils {

	public static boolean exportHotelObject(Hotel hotel) {

		boolean success = false;

		String fileName = hotel.getName() + "-" + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		fileName += ".ser";
		System.out.println(fileName);
		ObjectOutputStream oos = null;

		File exportFolder = new File("data");
		boolean structureCreated = exportFolder.exists() && exportFolder.isDirectory();

		if (!structureCreated)
			structureCreated = exportFolder.mkdirs();
		if (structureCreated)
			try {
				oos = new ObjectOutputStream(new FileOutputStream(new File(exportFolder, fileName)));
				oos.writeObject(hotel);
				oos.flush();

				success = true;
			} catch (IOException exc) {
				exc.printStackTrace();
				System.err.println(exc.getLocalizedMessage());
			} finally {
				if (oos != null)
					try {
						oos.close();
					} catch (IOException exc) {
						exc.printStackTrace();
					}
			}

		return success;
	}

	/**
	 * @param archiveFile
	 * @return
	 */
	public static Hotel importHotelObject(String archiveFile) {
		File file = new File(archiveFile);
		if (!file.exists())
			return null;
		if (!file.canRead())
			return null;
		if (!file.isFile())
			return null;
		ObjectInputStream ois = null;

		Hotel importedHotel = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			Object importedObject = ois.readObject();
			if (importedObject != null) {
				if (importedObject instanceof Hotel) {
					importedHotel = (Hotel) importedObject;
				}
			}

		} catch (IOException | ClassNotFoundException exc) {
			exc.printStackTrace();
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (IOException exc) {
					exc.printStackTrace();
				}
		}
		return importedHotel;
	}

	/**
	 * @param loyalKunden
	 * @return
	 */
	public static boolean exportLoyalKundenList(List<Guest> loyalKunden, String filePath) {

		boolean success = false;

		FileWriter fw = null;
		File file = new File(filePath);
		if (file.exists())
			System.out.println("File " + file + " existiert schon! Wird überschrieben");
		try {
			fw = new FileWriter(file);
			for (Guest kunde : loyalKunden)
				fw.append(kunde.toString() + System.getProperty("line.separator"));

			success = true;

			fw.flush();
		} catch (IOException exc) {
			exc.printStackTrace();
		} finally {
			if (fw != null)
				try {
					fw.close();
				} catch (IOException exc) {
					exc.printStackTrace();
				}
		}
		return success;
	}

	/**
	 * @param hotelDatenFile
	 * @return
	 */
	public static Hotel importHotelDaten(String hotelDatenFile) {

		Hotel hotel = null;

		File file = new File(hotelDatenFile);
		if (!file.exists())
			return null;
		if (!file.canRead())
			return null;
		if (!file.isFile())
			return null;

		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String hotelName = null;
			String strasse = null;
			String hausNr = null;
			String plz = null;
			String ort = null;

			if (reader.ready()) {
				hotelName = reader.readLine();
			}
			if (reader.ready())
				strasse = reader.readLine();
			if (reader.ready())
				hausNr = reader.readLine();
			if (reader.ready())
				plz = reader.readLine();
			if (reader.ready())
				ort = reader.readLine();

			// ... 
			hotel = new Hotel(hotelName);
			hotel.setLocation(new Address(strasse, hausNr, plz, ort));
		} catch (FileNotFoundException exc) {
			exc.printStackTrace();
		} catch (IOException exc) {
			exc.printStackTrace();
		}
		finally {
			if(reader!=null)
				try {
					reader.close();
				} catch (IOException exc) {
					exc.printStackTrace();
				}
		}

		return hotel;
	}

}
