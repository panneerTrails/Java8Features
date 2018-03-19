/**
 * 
 */
package com.michael.java8.features.streams;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author 109726
 *
 */
public class StreamingAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 //Create array of Integers
        Integer[] arr = {10,20,30,40,50};
        
        System.out.println("The Streaming of Array Elements Using Arrays Util Class");
        Stream<Integer> stream = Arrays.stream(arr);
        stream.forEach(System.out::println);
        
        System.out.println("The Streaming of Collection Of Elements Using Stream Interface");
        Stream<Integer> numberStream = Stream.of(10,20,30,40,50);
        numberStream.forEach(System.out::println);
        
        System.out.println("The Streaming of Array Of Elements Using Stream Interface");
        Stream<Integer> intArrayStream = Stream.of(arr);
        intArrayStream.forEach(System.out::println);

	}

}
