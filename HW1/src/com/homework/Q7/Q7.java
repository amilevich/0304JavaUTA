package com.homework.Q7;
/* Christopher Collins
 * Sort 2 employees by Name, Department, and Age
 */

import java.util.ArrayList;
import java.util.Collections;

public class Q7 {

	public static void main(String[] args) {
		
		// Create Array list
		ArrayList<Employee> DU = new ArrayList<Employee>();
		DU.add(new Employee("Yugi Muto", "Legend", 18 ));
		DU.add(new Employee("Seto Kaiba", "CEO", 18));
		
		
		// Output Array list in default form
		System.out.println("***Unsorted***");
		for(int D = 0; D < DU.size(); D++) {
			System.out.println(DU.get(D));
		}
		
		// Sort by name
		Collections.sort(DU, new SBName()); 
		  
		// Display Array list
		System.out.println("***Sorted by Name***");
		for(int D = 0; D < DU.size(); D++) {
			System.out.println(DU.get(D));
		}
		
		// Sort by Department
        Collections.sort(DU, new SBDepart()); 
        
		// Display Array list
        System.out.println("***Sorted by Department***");
		for(int D = 0; D < DU.size(); D++) {
			System.out.println(DU.get(D));
		}
		
		// Sort by Age
        Collections.sort(DU, new SBAge()); 
		
        // Display Array list
		System.out.println("***Sorted by Age***");
		for(int D = 0; D < DU.size(); D++) {
			System.out.println(DU.get(D));
		}
		
		
		
	}
}
