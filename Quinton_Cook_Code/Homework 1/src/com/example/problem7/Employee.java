package com.example.problem7;

public class Employee {

	protected String name;
	protected String department;
	protected int age;

	Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	
}
