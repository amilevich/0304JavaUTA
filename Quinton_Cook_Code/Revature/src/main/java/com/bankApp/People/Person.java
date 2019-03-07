package com.bankApp.People;

import java.util.HashMap;


/*
 * this will be the bean that all of the AccountHolders and Employee objects
 * extend, we're all human after all
 */
public class Person {
	protected String firstName;
	protected String lastName;
	protected String username;
	protected String password;
	protected static HashMap<String,Person> loginInfo = new HashMap<String,Person>();

	public Person(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
