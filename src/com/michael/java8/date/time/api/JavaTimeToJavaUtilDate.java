/**
 * 
 */
package com.michael.java8.date.time.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author 109726
 *
 */
public class JavaTimeToJavaUtilDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    //Asia/Kuala_Lumpur +8
        ZoneId defaultZoneId = ZoneId.systemDefault();
        System.out.println("System Default TimeZone : " + defaultZoneId);

        LocalDate localDate = LocalDate.of(2016, 8, 19);
        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        System.out.println("\n 1. LocalDate -> Date");
        System.out.println("Java Time localDate : " + localDate);
        System.out.println("Java Util date : " + date);

        LocalDateTime localDateTime = LocalDateTime.of(2016,8,19,21,46,31);
        Date date2 = Date.from(localDateTime.atZone(defaultZoneId).toInstant());
        System.out.println("\n 2. LocalDateTime -> Date");
        System.out.println("Java Time localDateTime : " + localDateTime);
        System.out.println("Java Util date2 : " + date2);

        ZonedDateTime zonedDateTime = localDateTime.atZone(defaultZoneId);
        Date date3 = Date.from(zonedDateTime.toInstant());
        System.out.println("\n 3. ZonedDateTime -> Date");
        System.out.println("Java Time zonedDateTime : " + zonedDateTime);
        System.out.println("Java Util date3 : " + date3);

	}

}
