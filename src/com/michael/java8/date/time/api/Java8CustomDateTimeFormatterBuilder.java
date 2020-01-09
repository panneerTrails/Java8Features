/**
 * 
 */
package com.michael.java8.date.time.api;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;

/**
 * @author 109726
 *
 */
public class Java8CustomDateTimeFormatterBuilder {

	/**
	 * 
	 */
	public Java8CustomDateTimeFormatterBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	public DateTimeFormatterBuilder getDateTimeFormatterBuilder(){
		DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
		dateTimeFormatterBuilder.appendText(ChronoField.DAY_OF_WEEK,TextStyle.SHORT)
		.appendLiteral(" ").appendText(ChronoField.MONTH_OF_YEAR,TextStyle.SHORT)
		.appendLiteral(" ").appendValue(ChronoField.DAY_OF_MONTH)
		.appendLiteral(" ").appendValue(ChronoField.YEAR)
		.appendLiteral(" ").appendValue(ChronoField.HOUR_OF_DAY,2)
		.appendLiteral(":").appendValue(ChronoField.MINUTE_OF_HOUR,2)
		.appendLiteral(":").appendValue(ChronoField.SECOND_OF_MINUTE,2)
		.appendLiteral(" ").appendLocalizedOffset(TextStyle.FULL)
		.appendLiteral(" ").appendLiteral("(").appendZoneText(TextStyle.FULL).appendLiteral(")");		
		return dateTimeFormatterBuilder;
	}
	
	public String getTheFormattedDateAndTimeByGivenLocale(String Locale){
		  ZoneId id = ZoneId.of(Locale);
	      DateTimeFormatter dateTimeFormatter = getDateTimeFormatterBuilder().toFormatter();
	      ZonedDateTime zonedDateTime = ZonedDateTime.now(id!=null?id:ZoneId.systemDefault());
	      String formattedDateAndTime = zonedDateTime.format(dateTimeFormatter);
	      return formattedDateAndTime;
	}
	
	public String getTheFormattedDateAndTime(){
		  ZoneId id = null;
	      DateTimeFormatter dateTimeFormatter = getDateTimeFormatterBuilder().toFormatter();
	      ZonedDateTime zonedDateTime = ZonedDateTime.now(id!=null?id:ZoneId.systemDefault());
	      String formattedDateAndTime = zonedDateTime.format(dateTimeFormatter);
	      return formattedDateAndTime;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZoneId defaultZoneId = ZoneId.systemDefault();
		System.out.println("System Default TimeZone : " + defaultZoneId);

		Java8CustomDateTimeFormatterBuilder zonedDateTimeAPI = new Java8CustomDateTimeFormatterBuilder();
		System.out.println("ZonedDateTime by given Locale and Custom Formatter -> " + zonedDateTimeAPI.getTheFormattedDateAndTimeByGivenLocale("Europe/Paris"));
		
		System.out.println("ZonedDateTime by given Custom Formatter -> " +zonedDateTimeAPI.getTheFormattedDateAndTime());

	}

}
