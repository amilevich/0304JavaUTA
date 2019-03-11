package com.project.user;

public class Customer extends User {
	
	private String location;
	private int age;
	
	
	public Customer(String username, String password, String type, String name) {
		super(username, password, type, name);
	}

	public Customer(String username, String password, String type, String name, String location, int age) {
		super(username, password, type, name);
		this.location = location;
		this.age= age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
