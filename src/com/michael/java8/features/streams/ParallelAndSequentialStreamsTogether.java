/**
 * 
 */
package com.michael.java8.features.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 109726
 *
 */
public class ParallelAndSequentialStreamsTogether {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> persons = new ArrayList<Person>();

		Person p1 = new Person("Michael", 32);
		persons.add(p1);
		Person p2 = new Person("Philomin", 29);
		persons.add(p2);
		Person p3 = new Person("Raj", 27);
		persons.add(p3);
		Person p4 = new Person("Jenifer", 25);
		persons.add(p4);
		Person p5 = new Person("Alfred", 5);
		persons.add(p5);

		System.out.println("The persons filtered and collected");
		List<Person> persons2 = persons.stream()
				.parallel()
				.filter(p -> p.getAge() > 18)  // filtering will be performed concurrently
				.collect(Collectors.toList());

		persons2.forEach(System.out::println);

		System.out.println();

		System.out.println("The persons filtered and collected as students");


		List<Student> students = persons.stream()
				.parallel()
				.filter(p -> p.getAge() > 18)  // filtering will be performed concurrently
				.sequential()
				.map(Student::new)
				.collect(Collectors.toCollection(ArrayList::new));

		students.forEach(System.out::println);


		System.out.println();

		System.out.println("The persons are just printed using method referrence in parallel stream");

		persons.stream().parallel().forEach(System.out::println);
	}

}
