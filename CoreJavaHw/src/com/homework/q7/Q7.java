package com.homework.q7;

import java.util.ArrayList;
import java.util.Collections;


public class Q7 {

	public static void main(String[] args) {
		
		//creates an ArrayList to hold employees 
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		//adds employees to the Employee ArrayList
		employees.add(new Employee("Emily", "Finance", 23));
		employees.add(new Employee("Timmy", "HR", 27));
		employees.add(new Employee("Molly", "Accounting", 23));
		
		
		//Calls the sorting method made and sorts the names 
		Collections.sort(employees, new SortByName());
		
		//prints out the sorted array
		for(Employee employee : employees)
			System.out.println(employee);
			
		

	}

}
