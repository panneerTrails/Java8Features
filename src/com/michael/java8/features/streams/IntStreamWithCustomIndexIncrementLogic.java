/**
 * 
 */
package com.michael.java8.features.streams;

import java.util.stream.IntStream;

/**
 * @author 109726
 *
 */
public class IntStreamWithCustomIndexIncrementLogic {

	public void displayTheRange(){
		int row = 0;
		int maxLimit = 121;

		IntStream.iterate(0, i -> i + 1).limit(10).forEach(System.out::println);

		//takeWhile has to be used for limiting the iteration of the loop when the custom index increment logic used
		// I mean the index is increased by more than a one number based on the condition at runtime

		// With Sequential Iteration
		System.out.println("With Sequential Iteration - takeWhile for custom increment in index");
		StreamUtil.takeWhile(IntStream.iterate(row, i -> i+40), i -> i < maxLimit).forEach(System.out::println);	


		// With Parallel Iteration
		System.out.println("With Parallel Iteration - - takeWhile for custom increment in index");
		StreamUtil.takeWhile(IntStream.iterate(row, i -> i+40), i -> i < maxLimit).parallel().forEach(System.out::println);	

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStreamWithCustomIndexIncrementLogic intStreamExample = new IntStreamWithCustomIndexIncrementLogic();
		intStreamExample.displayTheRange();
	}

}
