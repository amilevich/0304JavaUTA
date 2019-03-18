package com.project.model;

public class Customer {

	/*
	 CREATE TABLE CUSTOMER
		(
 		first_name VARCHAR2 (30),
 		last_name VARCHAR2 (30),
 		user_name VARCHAR2 (30) PRIMARY KEY,
 		pass_word VARCHAR2 (30)
		);
	 */
	
	String firstName; 
	String lastName; 
	String userName; 
	String passWord; 
	
	public Customer()
	{
		
	}

	public Customer(String firstName, String lastName, String userName, String passWord) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", passWord="
				+ passWord + "]";
	}
	
	
}
