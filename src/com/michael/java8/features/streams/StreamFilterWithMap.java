package com.michael.java8.features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.michael.java8.practice.model.Person;

public class StreamFilterWithMap {

	public static void main(String[] args) {

		List<Person> persons = Arrays.asList(
				new Person("mkyong", 30),
				new Person("jack", 20),
				new Person("lawrence", 40),
				new Person("jack", 50)
				);

		int age = persons.stream()
				//.parallel()
				.filter(x -> "jack".equals(x.getName()))
				.map(Person::getAge)                        //convert stream to String
				.findAny()
				// .findFirst()
				.orElse(0);

		System.out.println("name : " + age);

		List<String> collectedAsList = persons.stream()
				.map(Person::getName)
				.collect(Collectors.toList());

		System.out.println();

		System.out.println("Results Collected As List \n" );
		collectedAsList.forEach(System.out::println);

		Set<String> collectAsSet = persons.stream()
				.map(Person::getName)
				.collect(Collectors.toSet());

		System.out.println();

		System.out.println("Results Collected As Set \n" );
		collectAsSet.forEach(System.out::println);




		System.out.println();


		// Calculate squares and collect the distinct results
		System.out.println("Calculate squares and collect the distinct results");
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		//get list of unique squares
		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		squaresList.forEach(System.out::println);

		System.out.println();

		System.out.println("Finally display the sources");
		numbers.forEach(System.out::println);

	}


}
