package com.problem7;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Main {

	public static void main(String[] args) {
		List <Student> students = new ArrayList<Student> (); 
		students.add(new Student("Frank", "Science",21));
		students.add(new Student("Anne", "Math",19));
		
		printList(students);
		Collections.sort(students, new SortingComName()); // sorts by name
		printList(students);
		Collections.sort(students, new SortingComName());
		
	
	}
	
	static void printList(List<Student> list) {
		for (Student student: list) {
			System.out.println(student);
		}
	}

}
