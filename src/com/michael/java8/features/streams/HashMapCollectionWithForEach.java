/**
 * 
 */
package com.michael.java8.features.streams;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 109726
 *
 */
public class HashMapCollectionWithForEach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

	    items.forEach((k,v) -> System.out.println("Item : " + k + " Count : " + v));
	    
	    items.forEach((k,v) -> {
	    	System.out.println("Item : " + k + " Count : " + v);
	    	if("F".equals(k)){
	    		System.out.println("Hello F");
	    	}
	    });
	}

}
