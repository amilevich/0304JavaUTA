package com.example.sorting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnnaturalOrdering {

	/*
	 * Comparator interface - unnatural ordering, all values can be compared to all
	 * other values custom ordering
	 * 
	 * You have to specifically tell a sorting method. If you don't specify, then
	 * the sorting algorithm will use the natural ordering instead.
	 */
	public static void main(String[] args) {

		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, 6, "Frank", 4.0, LocalDate.of(2019, 3, 8)));
		students.add(new Student(4, 7, "Jimh", 3.3, LocalDate.of(2005, 1, 25)));
		students.add(new Student(17, 6, "Ki", 4.6, LocalDate.of(2019, 3, 9)));
		students.add(new Student(3, 2, "Ivar", 2.7, LocalDate.of(1407, 6, 6)));

		//System.out.println("Students sorted by Name A->Z: ");
//		Collections.sort(students, new StudentNameComparator());
//		printListPretty(students);
		
		System.out.println("Students sorted by descending dob: ");
		Collections.sort(students, new StudentDobComparator());
		printListPretty(students);
	}

	static void printListPretty(List<Student> list) {
		System.out.println("Students: ");
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println();
	}
}
