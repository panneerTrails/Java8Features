/**
 * 
 */
package com.michael.java8.date.time.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author 109726
 *
 */
public class DisplayDateInUtcFormat {

	/**
	 * 
	 */
	public DisplayDateInUtcFormat() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss 'GMT'Z (zzzz)");
		TimeZone zone = TimeZone.getTimeZone("ar-QA");
		simpleDateFormat.setTimeZone(zone);
		System.out.println(simpleDateFormat.format(new Date()));
	}
}
