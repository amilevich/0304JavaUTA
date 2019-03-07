package com.Homework1.Problem7;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {

		ArrayList<Employee> empList = new ArrayList<Employee>();	// I am using a list to store my employees
																	// Although the question asks for two, it is 
																	// beneficial to test with more employees
		empList.add(new Employee(20,"Henry","Sales"));
		empList.add(new Employee(31,"Marco","Management"));
		empList.add(new Employee(28,"Aaron","Security"));
		
		System.out.println("Original Order:");						// printing in original order
		
		for(Employee emp : empList)
			System.out.println(emp);
		
		Collections.sort(empList, new AgeComparator());				// Sorts the list using the AgeComparator
		
		System.out.println("\nSorted by Age:");						// printing after sorting by age
		
		for(Employee emp : empList)
			System.out.println(emp);
		
		Collections.sort(empList, new NameComparator());			// Sorts the list using the NameComparator
		
		System.out.println("\nSorted by Name:");					// printing after sorting by name
		
		for(Employee emp : empList)
			System.out.println(emp);
		
		Collections.sort(empList, new DepartmentComparator());		// Sorts the list using the DepartmentComparator
		
		System.out.println("\nSorted by Department:");				// printing after sorting by department
		
		for(Employee emp : empList)
			System.out.println(emp);
		
	}

}
