/**
 * 
 */
package com.michael.java8.defaultmethods;

/**
 * @author 109726
 *
 */
public class Car implements Vehicle, FourWheeler{
	public void print() {
		Vehicle.super.print();
		FourWheeler.super.print();
		Vehicle.blowHorn();
		System.out.println("I am a car!");
	}
}
