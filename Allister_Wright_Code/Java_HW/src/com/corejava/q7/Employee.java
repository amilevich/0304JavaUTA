package com.corejava.q7;

// Employee Bean
public class Employee
{
	// Attributes
	private String name;
	private String department;
	private int age;
	
	// Constructor with Attribute specification required
	protected Employee(String name, String dept, int age)
	{
		this.name = name;
		this.department = dept;
		this.age = age;
	}

	// ----====----
	// GETTERS AND SETTERS
	// ----====----
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
