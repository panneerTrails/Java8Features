/**
 * 
 */
package com.michael.java8.features.streams;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 109726
 *
 */
public class ArrayListCollectionWithForEach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> items = new ArrayList<>();
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("D");
		items.add("E");

		//lambda
		//Output : A,B,C,D,E
		items.forEach(item->System.out.println(item));
		
		System.out.println();


		//Output : C
		items.forEach(item->{
			if("C".equals(item)){
				System.out.println(item);
			}
		});

		System.out.println();

		//method reference
		//Output : A,B,C,D,E
		items.forEach(System.out::println);

		//Stream and filter , then use forEach to display the filtered elements
		//Output : B
		System.out.println();
		items.stream()
			.filter(item -> item.contains("B"))
			.forEach(System.out::println);
	}

}
