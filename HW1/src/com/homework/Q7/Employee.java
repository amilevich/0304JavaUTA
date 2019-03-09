package com.homework.Q7;

import java.util.Comparator;

class Employee {
	
	// Create Employee class
	String name, Department;
	int age;
	
	// Create constructor
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.Department = department;
		this.age = age;
	}
	
	// Display when GET
	public String toString() {
		return this.name + " " + this.Department + 
                " " + this.age;
	}

}

// Compare Names
class SBName implements Comparator<Employee> {
	public int compare (Employee a, Employee b) {
		return  a.name.compareTo(b.name);
	}
}

// Compare Departments
class SBDepart implements Comparator<Employee> {
	public int compare (Employee a, Employee b) {
		return  a.Department.compareTo(b.Department);
	}
}

// Compare Age
class SBAge implements Comparator<Employee> {
	public int compare (Employee a, Employee b) {
		return a.age - b.age;
	}
}
