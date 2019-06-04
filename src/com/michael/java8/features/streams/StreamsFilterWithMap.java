/**
 * 
 */
package com.michael.java8.features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.michael.java8.practice.model.Person;

/**
 * @author 109726
 *
 */
public class StreamsFilterWithMap {

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

		System.out.println();


		// Map only the names and display
		System.out.println("Map only the names and display");
		List<String> collect = persons.stream()
				.map(Person::getName)
				.collect(Collectors.toList());

		collect.forEach(System.out::println);

		System.out.println();

		// Filter the element's name which matches with 'jack' and display it
		System.out.println("Filter the element's name which matches with 'jack' and display it");
		Person person = persons.stream()
				.filter(x -> "jack".equals(x.getName()))
				.findAny()
				.orElse(null);

		System.out.println("The filtered person detais : " + person);

		System.out.println();

		// Filter the element's name which matches with 'jack' and display it
		System.out.println("Filter the element's name which matches with 'jack' and display it");
		String name = persons.stream()
				.filter(x -> "jack".equals(x.getName()))
				.map(Person::getName)                        //convert stream (Person) to String
				.findAny()
				.orElse("");

		System.out.println("The filtered person's name : " + name);
		
		
		System.out.println();

		
		//get count of empty string and use count API
		System.out.println("Get count of empty string and use count API");
		List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("The empty string count :" + count);
	}

}
