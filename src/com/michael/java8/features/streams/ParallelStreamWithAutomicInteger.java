/**
 * 
 */
package com.michael.java8.features.streams;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import com.michael.java8.practice.model.Person;

/**
 * @author 109726
 *
 */
public class ParallelStreamWithAutomicInteger {

	private final AtomicInteger sheetIndex = new AtomicInteger(1000);


	private String getCurrentTimeUsingDate() {
		Date date = new Date();
		String strDateFormat = "hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate= dateFormat.format(date);
		return formattedDate;
	}

	private boolean findSearchValue(Person person, String filter){
		boolean result = false;
		if(person.getName().equalsIgnoreCase(filter)){
			result = true;
		}
		return result;
	}

	private void setActiveIndex(List<Person> persons){
		int size = persons.size();

		IntStream.range(0, size).parallel().forEach( i -> {
			boolean searchResult = findSearchValue(persons.get(i),"jack");
			while(searchResult){ // This will retry until it updates the index if all conditions meet or else will return
				int currentSheetIndex = sheetIndex.get();
				System.out.println("the collection index -> " + i + "- the execution time " +getCurrentTimeUsingDate());
				System.out.println("current sheet index -> " + currentSheetIndex);
				if(i < currentSheetIndex){
					System.out.println("new index to be set-> " + i);
					if(sheetIndex.compareAndSet(currentSheetIndex, i)){
						return; // return the call after successfully updating the index
					}
				}else{
					System.out.println("condition not matched for  index -> " + i);
					return; // return the call if the active sheet index is lesser than the current sheet index.
				}
			}
		});

		if(sheetIndex.get() == 1000){
			System.out.println("The active sheet index - 0 ");        	  
		}else{
			System.out.println("The active sheet index : " + sheetIndex.get());        	  
		}


	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ParallelStreamWithAutomicInteger parallelStreamWithAutomicInteger = new ParallelStreamWithAutomicInteger();

		List<Person> persons = Arrays.asList(
				new Person("mkyong", 30),
				new Person("pan", 20),  // index 1
				new Person("lawrence", 40),
				new Person("jack", 50), // index 3
				new Person("mike", 46),
				new Person("jack",35), // index 5
				new Person("yousuf", 18),
				new Person("jack", 28));  // index 7

		System.out.println("just displaying the persons collection");
		persons.forEach(System.out::println);

		System.out.println();

		parallelStreamWithAutomicInteger.setActiveIndex(persons);


	}

}
