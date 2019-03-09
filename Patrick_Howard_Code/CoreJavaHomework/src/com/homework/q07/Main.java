package com.homework.q07;

import java.util.*;

class Employee {			//create a class employee for the paramaters
	int age;
	String department, name;

	public Employee(String name, String department, int age) {
		this.age = age;
		this.name = name;
		this.department = department;
	}

	public String toString() {					//Makes the parameters into a string
		return this.name + " " + this.department + " " + this.age;
	}
}

class SortbyName implements Comparator<Employee> {		// method to get both names and compare them
	public int compare(Employee a, Employee b) {
		return a.name.compareTo(b.name);
	}
}

class SortbyDepartment implements Comparator<Employee> {	// method to get both departments and compare them
	public int compare(Employee a, Employee b) {
		return a.department.compareTo(b.department);
	}
}

class SortbyAge implements Comparator<Employee> {	// method to get both ages and compare them
	public int compare(Employee a, Employee b) {
		return a.age - b.age;
	}
}

class Main {
	public static void main(String[] args) {
		ArrayList<Employee> ar = new ArrayList<Employee>();		// create 2 arrays with each persons data
		ar.add(new Employee("John Doe", "Tech Support", 32));
		ar.add(new Employee("Samantha Gardner", "Accountant", 24));

		System.out.println("Unsorted");			//just prints the arrays as is
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

		Collections.sort(ar, new SortbyName());	

		System.out.println("\nSorted by Name");	//sorts both arrays by their name by using the SortbyName class
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

		Collections.sort(ar, new SortbyDepartment());

		System.out.println("\nSorted by Department");	//sorts both arrays by their department by using the SortbyDepartment class
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

		Collections.sort(ar, new SortbyAge());

		System.out.println("\nSorted by Age");	//sorts both arrays by their age by using the SortbyAge class
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

	}
}