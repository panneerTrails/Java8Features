/**
 * 
 */
package com.michael.java8.practice.model;

import java.util.Optional;

/**
 * @author 109726
 *
 */

/**
 * @author 109726
 *
 */
public class PersonAsOptionalType {

	private String name;
	private int age;
	private String password;

	/**
	 * @param name
	 * @param age
	 * @param password
	 */
	public PersonAsOptionalType(String name, int age, String password) {
		super();
		this.name = name;
		this.age = age;
		this.password = password;
	}

	/**
	 * @param name
	 * @param age
	 */
	public PersonAsOptionalType(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	public Optional<Integer> getAge() {
		return Optional.ofNullable(age);
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Optional<String> getPassword() {
		return Optional.ofNullable(password);
	}


}