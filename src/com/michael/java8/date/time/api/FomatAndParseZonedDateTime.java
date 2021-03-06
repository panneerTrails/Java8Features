/**
 * 
 */
package com.michael.java8.date.time.api;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 109726
 *
 */
public class FomatAndParseZonedDateTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//2020-01-09T06:34:34.000+0000
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		ZonedDateTime givenZonedDateTimeParsed = ZonedDateTime.parse("2019-07-09T06:34:34.138+0530",formatter);


		System.out.println("\n 1. Given DateTime - zonedDateTimeParsed -> " + givenZonedDateTimeParsed);	

		System.out.println("\n 2. Current System - zonedDateTimeParsed -> " + ZonedDateTime.now());	

     	String zonedDateTimeFormatted = ZonedDateTime.now().format(formatter);
     	
		System.out.println("\n 3. Current System Date - ZonedDateTime.now() - Formatted -> " + zonedDateTimeFormatted);		   


		ZonedDateTime currentZonedDateTimeParsed = ZonedDateTime.parse(zonedDateTimeFormatted,formatter);

		System.out.println("\n 4. Current System Date - ZonedDateTime.now() - Parsed with specific formatter -> " + currentZonedDateTimeParsed);
	
		System.out.println("\n 5. Current System Date - ZonedDateTime.now() With ZoneId -> " + currentZonedDateTimeParsed.withZoneSameLocal(ZoneId.systemDefault()));


		Duration duration = Duration.between(givenZonedDateTimeParsed,currentZonedDateTimeParsed);
		System.out.println("\n 6. Difference between two given dates in days: " + duration.toDays());

		if(duration.toDays() >= 180){
			System.out.println("\n 7. Result  -> The ticket or activity has to be archived");
		}


		System.out.println("\n 8. Time Zone of zonedDateTimeParsed -> " + currentZonedDateTimeParsed.getZone());		

		System.out.println("\n 9. ZoneOffset of zonedDateTimeParsed -> " + currentZonedDateTimeParsed.getOffset());	

		System.out.println("\n 10. ZoneId with GMT of zonedDateTimeParsed -> " + ZoneOffset.ofOffset("GMT", currentZonedDateTimeParsed.getOffset()));	

		System.out.println("\n 11. ZoneId with UTC of zonedDateTimeParsed -> " + ZoneOffset.ofOffset("UTC", currentZonedDateTimeParsed.getOffset()));	


		System.out.println("\n Convert Calcutta LocalDateTime to Singapore LcoalDateTime ");	

		ZoneId singaporeZoneId = ZoneId.of("Asia/Singapore");
		System.out.println("TimeZone : " + singaporeZoneId);
		System.out.println("\n 12. Lcoal Singapore DateTime derived from Calcutta DateTime using ZoneId -> " + currentZonedDateTimeParsed.withZoneSameInstant(singaporeZoneId));

	}

}
