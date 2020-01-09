package com.michael.java8.forEach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachWithConsumerOrAnonymousClass {

	public static void main(String[] args) {

		//creating sample Collection
		List<Integer> myList = new ArrayList<Integer>();
		for(int i=0; i<10; i++) myList.add(i);

		//traversing using Iterator
		Iterator<Integer> it = myList.iterator();
		while(it.hasNext()){
			Integer i = it.next();
			System.out.println("Iterator Value::"+i);
		}

		//traversing through forEach method of 'Iterable' interface with anonymous class (java.util.function.Consumer object)
		//forEach method takes java.util.function.Consumer object as argument
		myList.forEach(new Consumer<Integer>() {

			public void accept(Integer t) {
				System.out.println("forEach Anonymous Class Value::"+t);
			}

		});

		//traversing with Consumer interface implementation
		MyConsumer action = new MyConsumer();
		myList.forEach(action);
	}
}

