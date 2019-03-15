package com.corejavahw.q7;

import java.util.Arrays;

/*
 * Sort two employees based on their name, department, and age using the 
 * Comparator interface.
 */

public class Q7 {

	//method to sort Employee Comparable
	public static void EmployeeSort() {
		//set employee array
		Employee[] empArr = new Employee[2];
		empArr[0] = new Employee(1,"Greg","Sales",28);
		empArr[1] = new Employee(2,"John","Marketing",30);
		
		//print unsorted list
        System.out.println("Unsorted List : " + Arrays.toString(empArr));

        //sort employees array using Comparator by Name
        Arrays.sort(empArr, Employee.NameComparator);
        System.out.println("Employees list sorted by Name:\n"+Arrays.toString(empArr));
        
        //sort employees array using Comparator by Department
        Arrays.sort(empArr, Employee.DeptComparator);
        System.out.println("Employees list sorted by Department:\n"+Arrays.toString(empArr));
        
        //sort employees array using Comparator by Age
        Arrays.sort(empArr, Employee.AgeComparator);
        System.out.println("Employees list sorted by Age:\n"+Arrays.toString(empArr));
	}
	
	//program driver
	public static void main(String[] args) {
		EmployeeSort();
	}
}
