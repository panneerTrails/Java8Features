/**
 * 
 */
package com.michael.java8.date.time.api;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author 109726
 *
 */
public class DifferenceBetweenTwoLocalDateTimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
        LocalDateTime localDateTimeBeforeSixMonths = LocalDateTime.of(2019,7,7,14,30,35);
        System.out.println("\n 1. LocalDateTime Before Six Months -> Date");
        System.out.println("\n localDateTimeBeforeSixMonths : " + localDateTimeBeforeSixMonths);
        
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        System.out.println("\n 2. LocalDateTime Now : " + localDateTimeNow);
        
        Duration duration = Duration.between(localDateTimeBeforeSixMonths,localDateTimeNow);
        System.out.println("\n 3. Difference between two given dates in days: " + duration.toDays());
        
        if(duration.toDays() >= 180){
            System.out.println("\n Result  -> The ticket or activity has to be archived");
        }

        
        
        System.out.println("\n 4. Finding difference between two different (time zoned) dates in hours");

        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime now = localDateTime.atZone(ZoneId.of("America/Montreal"));
        ZonedDateTime sixHoursBehind = now.withZoneSameInstant(ZoneId.of("Asia/Singapore")).minusHours(6);
         
        long diffInHours = ChronoUnit.HOURS.between(sixHoursBehind, now);
        
        if(diffInHours == 6){
            System.out.println("\n Result  -> The hours difference between given two dates are 6");
        }
        
        System.out.println("\n 5. Finding difference between two different (time zoned) dates in minutes");
        ZonedDateTime sixMinutesBehind = now.withZoneSameInstant(ZoneId.of("Asia/Singapore")).minusMinutes(6);
         
        long diffInMinutes = ChronoUnit.MINUTES.between(sixMinutesBehind, now);
        
        if(diffInMinutes == 6){
            System.out.println("\n Result  -> The minutes difference between given two dates are 6");
        }
        
        System.out.println("\n 6. Finding difference between two different (time zoned) dates in seconds");
        ZonedDateTime sixSecondsBehind = now.withZoneSameInstant(ZoneId.of("Asia/Singapore")).minusSeconds(6);
         
        long diffInSeconds = ChronoUnit.SECONDS.between(sixSecondsBehind, now);
        
        if(diffInSeconds == 6){
            System.out.println("\n Result  -> The seconds difference between given two dates are 6");
        }
       
    
	}

}
