package com.Homework1.Problem7;

import java.util.Comparator;

public class DepartmentComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		
		Employee emp1 = (Employee)o1;			// this method functions identically to nameComparitor
		Employee emp2 = (Employee)o2;
		
		return emp1.department.compareTo(emp2.department);	// both methods deal with string comparisons, the only 
														//difference is which member we compare, name or department
	}

}
