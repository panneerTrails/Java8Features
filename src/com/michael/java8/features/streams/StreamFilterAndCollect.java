/**
 * 
 */
package com.michael.java8.features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 109726
 *
 */
public class StreamFilterAndCollect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  List<String> lines = Arrays.asList("spring", "node", "mkyong");

	        List<String> result = lines.stream()                // convert list to stream
	                .filter(line -> !"mkyong".equals(line))     // we dont like mkyong
	                .collect(Collectors.toList());              // collect the output and convert streams to a List

	        result.forEach(System.out::println);                //output : spring, node

	}

}
