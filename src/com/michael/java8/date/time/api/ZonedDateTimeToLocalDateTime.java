/**
 * 
 */
package com.michael.java8.date.time.api;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 109726
 *
 */
public class ZonedDateTimeToLocalDateTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ZonedDateTime now = ZonedDateTime.now();
        System.out.println("\n 1.ZonedDateTime -> " + now);		

		
        //1 . ZonedDateTime to LocalDateTime
		System.out.println("\n 2.ZonedDateTime converted to LocalDateTime via toLocalDateTime -> " +  now.toLocalDateTime());	

        
		// 2. ZonedDateTime to TimeStamp
		Timestamp timestamp = Timestamp.valueOf(now.toLocalDateTime());
		System.out.println("\n 3.ZonedDateTime converted to TimeStamp via toLocalDateTime -> " + timestamp);	

		// 3. ZonedDateTime to TimeStamp , no different
		Timestamp timestamp2 = Timestamp.from(now.toInstant());

		System.out.println("\n 4.ZonedDateTime converted to TimeStamp via toInstant -> " + timestamp2);


	}

}
