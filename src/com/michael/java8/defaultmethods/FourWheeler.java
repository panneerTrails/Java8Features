/**
 * 
 */
package com.michael.java8.defaultmethods;

/**
 * @author 109726
 *
 */
public interface FourWheeler {
	default void print() {
		System.out.println("I am a four wheeler!");
	}
}
