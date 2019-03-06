package com.example.problem7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public  Comparer c = new Comparer();
	
	public static void main(String[] args) {
		Employee quinton = new Employee("Quinton", "Associate", 21);
		Employee quinton2 = new Employee("Quinton","Bowling", 21);
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(quinton2);
		employees.add(quinton);
		
		Collections.sort(employees, new Comparer());
		
		for(Employee i: employees)
			System.out.println(i);
	}
	
	/*
	 * the ordering that this comparer imposes is as follows:
	 * -name by alphabetical order
	 * -department by alphabetical order
	 * -age by magnitude
	 */
	
	public static class Comparer implements Comparator<Employee>{
	
	@Override
	public int compare(Employee arg0, Employee arg1) {

		// compare the names
		switch (arg0.name.compareToIgnoreCase(arg1.name)) {
		case -1:
			return -1;

		case 1:
			return 1;

		default:
			break;
		}

		// if the name is the same, compare the department
		switch (arg0.department.compareToIgnoreCase(arg1.department)) {
		case -1:
			return -1;

		case 1:
			return 1;

		default:
			break;
		}

		// if the department is the same, compare the age
		if (arg0.age < arg1.age) {
			return -1;
		} else if (arg1.age > arg0.age) {
			return 1;
		} else {
			return 0;
		}
	}
	}
	
}
