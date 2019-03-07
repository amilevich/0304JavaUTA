package com.Homework1.Problem7;

import java.util.Comparator;

public class NameComparator implements Comparator {	// again we implement Comparator

	@Override
	public int compare(Object o1, Object o2) {
		
		Employee emp1 = (Employee)o1;			// again we create employees and assign the arguments to them
		Employee emp2 = (Employee)o2;
												// we don't need to generate the comparison logic because we are
												// comparing strings and the String class has a compareTo method
												// we can use, as long as we order our inputs correctly.
		return emp1.name.compareTo(emp2.name);
		
	}

}
