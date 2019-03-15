package com.homework.question7;

import java.util.ArrayList;
import java.util.Collections;

// Reference: https://www.geeksforgeeks.org/comparator-interface-java/
public class Main {
	public static void main(String[] args)
	{
		// Q7. Sort two employees based on their name, 
		// department, and age using the Comparator interface.
		
		ArrayList<Employees> em = new ArrayList<Employees>(); 
		em.add(new Employees(25, "Steve", "Wood")); 
		em.add(new Employees(21, "Jake", "Paint")); 
		
		System.out.println("Unsorted");
		for(int i = 0; i<em.size(); i++)
			System.out.println(em.get(i));
		
		Collections.sort(em,  new SortByName());
		
		System.out.println("\nSorted by name");
		for(int i=0; i<em.size(); i++)
			System.out.println(em.get(i));
	}
}
