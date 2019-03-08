package com.example.sorting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NaturalOrdering {
	
	// Comparable Interface (natural ordering)
	// ordering is provided by the JVM
	// interface allows to sort based on one element
	// numbers - ascending
	// characters - unicode values

	public static void main(String[] args) {

		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, 6, "Frank", 4.0, LocalDate.of(2019, 3, 8)));
		students.add(new Student(4, 7, "Jimh", 3.3, LocalDate.of(2005, 1, 25)));
		students.add(new Student(17, 6, "Ki", 4.6, LocalDate.of(2019, 3, 9)));
		students.add(new Student(3, 2, "Ivar", 2.7, LocalDate.of(1407, 6, 6)));
		
		printListPretty(students);
		
		Collections.sort(students);
		// collections - utility class filled with static methods
		// to be used on the data structures from the Collection API
		
		printListPretty(students);
	}
	
	static void printListPretty(List<Student> list) {
		System.out.println("Students: ");
		for(Student student: list) {
			System.out.println(student);
		}
	}

}
