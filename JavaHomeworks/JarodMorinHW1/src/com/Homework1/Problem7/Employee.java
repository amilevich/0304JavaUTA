package com.Homework1.Problem7;

public class Employee {

	int age;					// This class contains members for each characteristic we are sorting by
	String name;
	String department;
								// A constructor is defined to facilitate initialization
	Employee(int age, String name, String department){
		this.age = age;
		this.name = name;
		this.department = department;
	}
	
	public String toString() {	// toString for easy printing
		
		return "Age: " + age + " Name: " + name + " Department: " + department;
	}
	
}
