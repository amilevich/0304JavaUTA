package com.models.beans;

public class Customer {
	
	String username; 
	String password;
	
	public Customer() {
	}
	
	

	
	
	public Customer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
