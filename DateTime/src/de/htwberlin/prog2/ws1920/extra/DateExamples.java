/**
 * checkout https://www.baeldung.com/java-8-date-time-intro
 */
package de.htwberlin.prog2.ws1920.extra;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * @author abujarour
 *
 */
public class DateExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		checkoutLocalDate();

		System.out.println("===\n\n");

		checkoutLocalTime();

		System.out.println("***\n\n");
		checkoutLocalDateTime();

		System.out.println("######\n\n");
		checkoutZonedDateTime();
	}

	private static void checkoutLocalDate() {
		System.out.println("DateExamples.checkoutLocalDate()");
		
		LocalDate localDate = LocalDate.now();
		System.out.println("01.\t" + localDate);

		localDate = LocalDate.of(2019, 02, 20);
		System.out.println("02.\t" + localDate);

		localDate = LocalDate.parse("2019-02-20");
		System.out.println("03.\t" + localDate);
		
		Date date = new Date();
		localDate = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
		System.out.println("04.\t" + localDate);

		LocalDate tomorrow = LocalDate.now().plusDays(1);
		System.out.println("05.\t" + tomorrow);


		LocalDate previousMonthSameDay = LocalDate.now().minus(2, ChronoUnit.MONTHS);
		System.out.println("06.\t" + previousMonthSameDay);


		DayOfWeek day = LocalDate.parse("2019-06-12").getDayOfWeek();
		System.out.println("07.\t" + day);

		int dayOfMonth = LocalDate.parse("2019-06-12").getDayOfMonth();
		System.out.println("08.\t" + dayOfMonth);

		boolean notBefore = LocalDate.parse("2019-06-12").isBefore(LocalDate.parse("2019-06-11"));
		boolean isAfter = LocalDate.parse("2019-06-12").isAfter(LocalDate.parse("2019-06-11"));

		System.out.println("09.\t" + notBefore);
		System.out.println("10.\t" + isAfter);
		
		int period = Period.between(localDate, tomorrow).getDays();
		System.out.println("11.\t" + period);

	}

	private static void checkoutLocalTime() {

		System.out.println("DateExamples.checkoutLocalTime()");
		
		LocalTime now = LocalTime.now();
		System.out.println("20.\t" + now);

		LocalTime sixThirty = LocalTime.parse("06:30");
		System.out.println("21.\t" + sixThirty);

		sixThirty = LocalTime.of(6, 30);
		System.out.println("22.\t" + sixThirty);
		
		LocalTime time = LocalTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
		System.out.println("23.\t" + time);

		LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
		System.out.println("24.\t" + sevenThirty);

		int hour = sixThirty.getHour();
		System.out.println("25.\t" + hour);

		boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));
		System.out.println("26.\t" + isbefore);
		
		long duration = Duration.between(sixThirty, sevenThirty).getSeconds();
		System.out.println("27.\t" + duration + " seconds");

	}

	private static void checkoutLocalDateTime() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);

		LocalDateTime dateTime = LocalDateTime.of(2019, Month.FEBRUARY, 20, 06, 30);
		System.out.println(dateTime);

		String formatted_UK = dateTime
				.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.UK));
		String formatted_DE = dateTime
				.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.GERMAN));
		String userFormatted = dateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

		System.out.println(formatted_UK);
		System.out.println(formatted_DE);
		System.out.println(userFormatted);
	}

	private static void checkoutZonedDateTime() {
		
		ZoneId parisTimezone = ZoneId.of("Europe/Paris");

		ZonedDateTime parisDateTime = ZonedDateTime.of(LocalDateTime.now(), parisTimezone);
		ZoneId newYork = ZoneId.of("America/New_York");
		ZonedDateTime newYorkDateTime = ZonedDateTime.of(LocalDateTime.now(), newYork);

		System.out.println(parisDateTime);
		System.out.println(newYorkDateTime);
		
		String userFormatted = parisDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm"));
		System.out.println(userFormatted);

		 userFormatted = newYorkDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm"));

		System.out.println(userFormatted);

	}

}
