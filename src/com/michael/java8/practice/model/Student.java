/**
 * 
 */
package com.michael.java8.practice.model;


/**
 * @author 109726
 *
 */
public class Student {

	private Person person;
	
	public Student(Person person){
		this.person = person;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [person=" + person + "]";
	}
	
	
	
}
