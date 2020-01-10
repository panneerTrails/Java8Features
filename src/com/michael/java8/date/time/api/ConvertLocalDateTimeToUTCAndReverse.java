/**
 * 
 */
package com.michael.java8.date.time.api;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 109726
 *
 */
public class ConvertLocalDateTimeToUTCAndReverse {

	 private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";
	 private static DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);

	    public static void main(String[] args) {

	        String dateInString = "22-1-2015 10:15:55 AM";
	        LocalDateTime ldt = LocalDateTime.parse(dateInString, format);
	        
	        System.out.println("LocalDateTime  : " + ldt);

	        ZoneId singaporeZoneId = ZoneId.of("Asia/Singapore");
	        System.out.println("TimeZone : " + singaporeZoneId);

	        //LocalDateTime + ZoneId = ZonedDateTime
	        ZonedDateTime singaporeZonedDateTime = ldt.atZone(singaporeZoneId);
	        System.out.println("DateTime in (Singapore) : " + singaporeZonedDateTime);
	        
	        ZoneId calcuttaZoneId = ZoneId.systemDefault();
	        System.out.println("TimeZone : " + calcuttaZoneId);
	        
	        ZonedDateTime calcuttaDateTime = singaporeZonedDateTime.withZoneSameInstant(calcuttaZoneId);
	        System.out.println("DateTime in (Calcutta) : " + calcuttaDateTime);

	        ZoneId newYokZoneId = ZoneId.of("America/New_York");
	        System.out.println("TimeZone : " + newYokZoneId);

	        ZonedDateTime newYorkDateTime = singaporeZonedDateTime.withZoneSameInstant(newYokZoneId);
	        System.out.println("DateTime in (New York) : " + newYorkDateTime); 
	        

	        System.out.println("\n---DateTimeFormatter---");
	        System.out.println("Formatted DateTime in (Singapore) : " + format.format(singaporeZonedDateTime));
	        System.out.println("Formatted DateTime in (Calcutta) : " + format.format(calcuttaDateTime));
	        System.out.println("Formatted DateTime in (New York) : " + format.format(newYorkDateTime));
	        
	        // Convert UTC time to LocalDateTime from ZonedDateTime (UTC/GMT format)
	        System.out.println("\n---LocalDateTime Of Given ZonedDateTime---");
	        System.out.println("Local DateTime in (Singapore) : " + singaporeZonedDateTime.toLocalDateTime());
	        System.out.println("Local DateTime in (Calcutta) : " + calcuttaDateTime.toLocalDateTime());
	        System.out.println("Local DateTime in (New York) : " + newYorkDateTime.toLocalDateTime()); 

	        

	    }
}
