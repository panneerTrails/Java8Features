package com.michael.java8.forEach;

import java.util.function.Consumer;


//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>{

	public void accept(Integer t) {
		System.out.println("forEach Consumer Implementation Value::" + t);
	}

}