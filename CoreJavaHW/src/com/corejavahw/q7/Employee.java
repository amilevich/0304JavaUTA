package com.corejavahw.q7;

import java.util.Comparator;

//implement interface
public class Employee implements Comparable<Employee> {
	// declare variables
	private int id;
	private String name;
	private String dept;
	private int age;

	// instantiate Comparator by Name
	public static final Comparator<Employee> NameComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee x1, Employee x2) {
			return x1.name.compareTo(x2.name);
		}
	};

	// instantiate Comparator by Department
	public static final Comparator<Employee> DeptComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee x1, Employee x2) {
			return x1.dept.compareTo(x2.dept);
		}
	};

	// instantiate Comparator by Age
	public static final Comparator<Employee> AgeComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee x1, Employee x2) {
			return x1.age - x2.age;
		}
	};

	// Employee constructor
	public Employee(int id, String name, String dept, int age) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.age = age;

	}

	@Override
	// sort by id in ascending order
	public int compareTo(Employee x) {
		return this.id - x.id;
	}

	@Override
	// print info about Employee
	public String toString() {
		return "[id=" + this.id + ", name=" + this.name + ", dept=" + this.dept + ", age=" + this.age + "]";
	}

}
