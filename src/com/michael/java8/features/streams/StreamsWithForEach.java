/**
 * 
 */
package com.michael.java8.features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.michael.java8.practice.model.Person;

/**
 * @author 109726
 *
 */
public class StreamsWithForEach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<Person> persons = Arrays.asList(
				new Person("mkyong", 30),
				new Person("jack", 20),
				new Person("lawrence", 40)
				);

		// Display the collection using forEach with method reference
		System.out.println("Display the collection using forEach with method reference");
		persons.stream().forEach(System.out::println);
		
		System.out.println();

		//The ‘limit’ method is used to reduce the size of the stream. The following code segment shows how to print 10 random numbers using limit.
		System.out.println("Display the random numbers generated");
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		
		System.out.println();

		
		//The ‘sorted’ method is used to sort the stream. The following code segment shows how to print 10 random numbers in a sorted order.
		System.out.println("Display the random numbers generated and sorted");
		random.ints().limit(10).sorted().forEach(System.out::println);
		
	}

}
