package com.problem.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {

		Employee emp1 = new Employee("Bob", "Accounting", 22);
		Employee emp2 = new Employee("Tom", "Billing", 55);
		Employee emp3 = new Employee("Yommy", "Chilling", 35);
		Employee emp4 = new Employee("Andy", "Web Dev", 32);

		ArrayList<Employee> list = new ArrayList<Employee>();

		// adding all employees
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);

		// Sort by name
		System.out.println("Sorted by Name: ");
		NameCompare nameCompare = new NameCompare();
		Collections.sort(list, nameCompare);
		for (Employee emp : list) {

			System.out.println(emp.getName() + " " + emp.getAge() + " " + emp.getDepartment());

		}

		// sort by department
		System.out.println("\nSorted by Department: ");
		DeptCompare deptCompare = new DeptCompare();
		Collections.sort(list, deptCompare);
		for (Employee emp : list) {

			System.out.println(emp.getName() + " " + emp.getAge() + " " + emp.getDepartment());
		}

		// sort by age
		System.out.println("\nSorted by Age: ");
		Collections.sort(list);
		for (Employee emp : list) {

			System.out.println(emp.getName() + " " + emp.getAge() + " " + emp.getDepartment());
		}

	}

}

class Employee implements Comparable<Employee> {

	private String name;
	private String department;
	private int age;

	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public int compareTo(Employee m) {
		return this.age - m.age;
	}

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

// Here are the Comparator classes
class NameCompare implements Comparator<Employee> {
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}
}

class DeptCompare implements Comparator<Employee> {
	public int compare(Employee e1, Employee e2) {
		return e1.getDepartment().compareTo(e2.getDepartment());
	}
}
