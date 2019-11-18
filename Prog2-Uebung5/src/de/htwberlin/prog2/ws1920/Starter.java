package de.htwberlin.prog2.ws1920;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Starter {

	private static Scanner scan = new Scanner(System.in);
	private static Hotel motelOne;

	public static void main(String[] args) {
		motelOne = new Hotel("Motel One");
		initHotel(motelOne);
		makeSomeReservations(motelOne);

		while (true) {
			showMenue();
			int choice = readUserInput();
			processUserInput(choice);
		}
	}

	private static void showMenue() {

		String menuEntries[] = { "Alle Reservierungen zeigen",
				"Alle Reservierungen eines Tages nach Gast sortieren und zeigen", "Loyal Kunden zeigen",
				"Alle Kunden sortiert nach Punkte absteigend, nach Nachname aufsteigend zeigen" , 
				"Beenden" };

		System.out.println("Menü");
		System.out.println("=====");

		for (int i = 0; i < menuEntries.length; i++) {
			System.out.println((i + 1) + ".\t" + menuEntries[i]);
		}

	}

	private static int readUserInput() {

		int choice = -1;

		System.out.print("Auswahl:" + "\t");

		if (scan.hasNextLine()) {
			String stringChoice = scan.nextLine();
			try {

				choice = Integer.parseInt(stringChoice);
			} catch (NumberFormatException nfe) {
				System.err.println(nfe.getMessage());
			}
		}
		System.out.println();

		return choice;
	}

	private static void processUserInput(int choice) {

		switch (choice) {
		case 1:
			showReservations();
			break;
		case 2:
			showSortedReservations();
			break;
		case 3:
			showLoyalCustomers();
			break;
		case 4:
			showSortedCustomers();
			break;
		case 5:
			quitApp();
			break;
		default: {
			System.out.println("Invalider Input!");
			scan.reset();
		}

		}
	}

	private static void showSortedCustomers() {

		Set<Guest> guests = motelOne.getGuests();
		List<Guest> guestList = new ArrayList<>(guests);
		
		for(Guest guest : guestList) {
			System.out.println(guest);
		}
		System.out.println();
		Collections.sort(guestList, new GuestComparator());
		for(Guest guest : guestList) {
			System.out.println(guest);
		}

	}

	private static void showLoyalCustomers() {

		Map<Guest, Long> loyalCustomers = motelOne.getLoyalCustomers();
		
		for(Map.Entry<Guest, Long> entry: loyalCustomers.entrySet()) {
			
			System.out.println(entry);
		}
	}

	private static void showSortedReservations() {
		System.out.println("Starter.showSortedReservations()");

		LocalDate day = readDate();
//		List<Reservation> filteredReservations = filterReservations(motelOne.getReservations(), day);
		Set<Reservation> filteredReservations = motelOne.getReservations(day);

		if(filteredReservations != null)
		for (Reservation reservation : filteredReservations)
			System.out.println(reservation);

		System.out.println(day);
	}

	private static List<Reservation> filterReservations(List<Reservation> reservations, LocalDate day) {
		// TODO Auto-generated method stub
		return reservations;
	}

	private static LocalDate readDate() {
		LocalDate day = null;
		while (day == null) {

			System.out.print("Datum (tt.mm.jjjj)" + ":\t");

			if (scan.hasNextLine()) {
				String stringDay = scan.nextLine();
				try {
					day = LocalDate.parse(stringDay,
							DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN));
				} catch (DateTimeParseException exc) {
					System.err.println(exc.getMessage());
				}
			}

		}
		return day;
	}

	private static void showReservations() {

		List<Reservation> reservations = motelOne.getReservations();
		for (Reservation reservation : reservations)
			System.out.println(reservation);

	}

	private static void quitApp() {
		scan.close();
		System.exit(0);
	}

	private static void makeSomeReservations(Hotel motelOne) {
		Guest guests[] = loadGuests();
		LocalDateTime startTime = LocalDateTime.of(2019, 11, 1, 0, 0);
		Random rand = new Random();
		for (int i = 0; i < 40; i++) {
			LocalDateTime from = startTime.plusDays(rand.nextInt(30));
			LocalDateTime to = from.plusDays(rand.nextInt(10) + 1);
			Guest guest = guests[rand.nextInt(guests.length)];
			motelOne.einZimmerBuchen(from, to, guest);
		}
	}

	private static Guest[] loadGuests() {

		Guest darrin = new Guest("Darrin", "Blake");
		Guest maxwell = new Guest("Maxwell", "Ferber");
		Guest scott = new Guest("Scott", "Turner");
		Guest emma = new Guest("Emma", "Ferber");
		Guest flora = new Guest("Flora", "Toller");
		Guest hartmann = new Guest("Hartmann", "Toller");
		Guest vera = new Guest("Vera", "Hooker");
		Guest brandt = new Guest("Brandt", "Siegel");
		Guest gerhard = new Guest("Gerhard", "Fletcher");
		Guest martina = new Guest("Martina", "Abbott");
		Guest sara = new Guest("Sara", "Young");
		Guest sabine = new Guest("Sabine", "Hunt");
		return new Guest[] { darrin, maxwell, scott, emma, flora, hartmann, vera, sara, sabine};
	}

	private static void initHotel(Hotel motelOne) {
		for (int i = 1; i < 11; i++)
			motelOne.addService(new Einzelzimmer("E" + i));

		for (int i = 1; i < 21; i++)
			motelOne.addService(new Einzelzimmer("D" + i));

		for (int i = 1; i < 20; i++)
			motelOne.addService(new Fahrrad("F" + i));
	}

}
