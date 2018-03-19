/**
 * 
 */
package com.michael.java8.features.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 109726
 *
 */
public class StreamExample {
	
	private static void processElement(int num) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	private void displayExecutionTimeDiffBetweenStreamAndParallellStream(List<Integer> numbers){
		 // Process data sequentially
        long startTime = System.currentTimeMillis();
        numbers.stream().forEach(i -> processElement(i));
        long endTime = System.currentTimeMillis();
        double timeTaken = (endTime - startTime) / 1000;
        System.out.println("Time taken with stream() : " + timeTaken + " milliseconds");
 
        // Process data in parallel
        startTime = System.currentTimeMillis();
        numbers.parallelStream().forEach(i -> processElement(i));
        endTime = System.currentTimeMillis();
        timeTaken = (endTime - startTime) / 1000;
        System.out.println("Time taken with parallelStream() : " + timeTaken + " milliseconds");
	}
	
	private void displayParallelStreamProcessWithoutOrder(){
        long startTime = System.currentTimeMillis();
		 Arrays.asList("Germany", "England",
			        "China", "Denmark", "Brazil").parallelStream().forEach(System.out::println);
		 long totalExecutionTime = System.currentTimeMillis() - startTime;
		 System.out.println("DisplayParallelStreamProcessWithoutOrder - Total execution time in milli seconds : " + totalExecutionTime);
	}
	
	private void displayParallelStreamProcessWithOrder(){
        long startTime = System.currentTimeMillis();
		 Arrays.asList("Germany", "England",
			        "China", "Denmark", "Brazil").parallelStream().forEachOrdered(System.out::println);
		 long totalExecutionTime = System.currentTimeMillis() - startTime;
		 System.out.println("DisplayParallelStreamProcessWithOrder - Total execution time in milli seconds : " + totalExecutionTime);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        // Add code here
		StreamExample streamExample = new StreamExample();
		//streamExample.displayParallelStreamProcessWithOrder();
		//streamExample.displayParallelStreamProcessWithoutOrder();
		List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            numbers.add(i);
        }
        streamExample.displayExecutionTimeDiffBetweenStreamAndParallellStream(numbers);
	}

}
