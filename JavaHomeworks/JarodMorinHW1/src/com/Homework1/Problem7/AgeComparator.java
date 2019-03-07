package com.Homework1.Problem7;

import java.util.Comparator;

public class AgeComparator implements Comparator {	// have to implement Comparator interface

	@Override
	public int compare(Object o1, Object o2) {
		
		Employee emp1 = (Employee)o1;			// we will be accessing Employee class variables, so we must
												// create new employee references and assign the argument objects
												// to them using casting.
		Employee emp2 = (Employee)o2;
												// compare returns a 0 if objects are equal, 1 if object 1 is greater
												// than object 2 and -1 if object 1 is lesser than object 2.
												// we use a nested if else statement to achieve this
		if(emp1.age == emp2.age)
		{
			return 0;
		}
		else	
		if(emp1.age > emp2.age) {
			return 1;
		}
		else
		{
			return -1;	
		}
	}

}
