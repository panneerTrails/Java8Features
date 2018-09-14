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
public class ZonedDateTimeAPI {

	/**
	 * 
	 */
	public ZonedDateTimeAPI() {
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
	
	public String getTheFormattedDateAndTime(String Locale){
		  ZoneId id = null;
	      id = ZoneId.of(Locale);
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
		ZonedDateTimeAPI zonedDateTimeAPI = new ZonedDateTimeAPI();
		System.out.println(zonedDateTimeAPI.getTheFormattedDateAndTime("Europe/Paris"));
	}

}
