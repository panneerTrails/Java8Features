/**
 * 
 */
package com.michael.java8.defaultmethods;

/**
 * @author 109726
 *
 */
public interface Vehicle {
	default void print() {
		System.out.println("I am a vehicle!");
	}

	static void blowHorn() {
		System.out.println("Blowing horn!!!");
	}
}
