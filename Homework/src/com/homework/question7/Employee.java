package com.homework.question7;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
	int id;
	String name;
	String department;
	int age;

	public Employee(int id, String name, String department, int age) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.age = age;
	}
	 public static Comparator<Employee> NameComparator = new Comparator<Employee>(){

	        @Override
	        public int compare(Employee a, Employee b) {
	            return a.name.compareTo(b.name);
	        }
	    };
	public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {

	        @Override
	        public int compare(Employee a, Employee b) {
	            return a.age - b.age;
	        }
	};
	
	public static Comparator<Employee> DepartmentComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee a, Employee b) {
            return a.department.compareTo(b.department);
        }
    };

@Override
public int compareTo(Employee x) {
	return this.id - x.id;
}

@Override
public String toString() { 
	return "[id=" + this.id + ", name=" + this.name + ", dept=" + this.department + ", age=" + this.age + "]";
}
}


