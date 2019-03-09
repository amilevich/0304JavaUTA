package com.homework.question7;

import java.util.Arrays;

public class Sortation {
	
	public static void main(String[] args) {
		Employee[] empArr = new Employee[2];
		empArr[0] = new Employee(1,"Barry", "Marketing", 28);
		empArr[1] = new Employee(2,"Terry", "Sales", 40);
		
		System.out.println("Unsorted List:" + Arrays.toString(empArr));
		
		
	Arrays.sort(empArr,Employee.NameComparator);
	System.out.println(Arrays.toString(empArr));
	
	Arrays.sort(empArr, Employee.DepartmentComparator);
	System.out.println(Arrays.toString(empArr));
	
	Arrays.sort(empArr,Employee.AgeComparator);
	System.out.println(Arrays.toString(empArr));
		
	}

}
