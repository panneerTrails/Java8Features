/**
 * 
 */
package com.michael.java8.features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author 109726
 *
 */
public class IterateOverStreamWithIndices {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] alphabets = {"A","B","C","D","E","F"};

		System.out.println("Intstream with range over the collection");
		IntStream.range(0, alphabets.length).forEach(index-> System.out.println(index + " -> " + alphabets[index]));

		System.out.println();

		System.out.println("Intstream with range over the collection to convert Stream of Strings to List of Strings");
		List<String> result = IntStream.range(0, alphabets.length)
				.mapToObj(index -> String.format("%d -> %s", index,alphabets[index]))
				.collect(Collectors.toList());

		result.forEach(System.out::println);

		System.out.println();

		System.out.println("Intstream with range over the collection to convert Stream of Strings to List of Strings to be displayed");
		IntStream.range(0, alphabets.length)
		.mapToObj(index -> String.format("%d -> %s", index,alphabets[index]))
		.forEach(System.out::println);

		System.out.println();

		System.out.println("Intstream with range closed over the collection - sequential");
		IntStream.rangeClosed(0, alphabets.length-1).forEach(index-> System.out.println(index + " -> " + alphabets[index]));

		System.out.println();

		System.out.println("Using AtomicInteger With Arrays.stream - sequential");
		AtomicInteger index = new AtomicInteger();
		Arrays.stream(alphabets).map(str -> index.getAndIncrement() + "->" + str).forEach(System.out::println);

		System.out.println();

		System.out.println("Using AtomicInteger With Arrays.stream - parallel");
		AtomicInteger indexParallel = new AtomicInteger();
		Arrays.stream(alphabets).parallel().map(str -> indexParallel.getAndIncrement() + "->" + str).forEach(System.out::println);

		System.out.println();

		System.out.println("Using IntStream with filter");
		List<String> evenIndexedAlphabets = IntStream.range(0, alphabets.length)
				.filter(i -> i % 2 == 0)
				.mapToObj(i -> alphabets[i])
				.collect(Collectors.toList());

		evenIndexedAlphabets.forEach(System.out::println);

	}

}
