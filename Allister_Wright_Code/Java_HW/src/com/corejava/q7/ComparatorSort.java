package com.corejava.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ComparatorSort {
	
	public static void main(String[] args) {
		// Comparator Usage sourced from
		// 	https://www.javatpoint.com/Comparator-interface-in-collection-framework
		
		// Initialise ArrayList of Employees
		ArrayList<Employee> al = new ArrayList<Employee>();
		
		al.add(new Employee("Rose", "Research", 22));
		al.add(new Employee("Jack", "Operations", 34));
//		al.add(new Employee("Fred", "Management", 38));
//		al.add(new Employee("Kevin", "Engineering", 24));
		
		// Declare Iterator to be used in each Collection
		Iterator<Employee> itr;
		
		// For Every Field in Employee
		for (int i = 0; i < 3; i++) 
		{
			// Break up Console output by Sorting Type
			// Sort ArrayList by field defined by Comparator
			switch(i) 
			{
				case 0:
					System.out.println("***Sorting by Name***");
					Collections.sort(al,new NameComparator());
					break;
				case 1:
					System.out.println("***Sorting by Departmnet***");
					Collections.sort(al,new DepartmentComparator());
					break;
				case 2:
					System.out.println("***Sorting by Age***");
					Collections.sort(al,new AgeComparator());
					break;
			}
			
			// Reinstantiate Iterator for current sort type
			itr = al.iterator();
			
			// For each Employee
			while(itr.hasNext()){  
				Employee emp = (Employee)itr.next();
				// Print Table Row for Current Employee
				System.out.println(
					emp.getName() + "\t" + 
					emp.getDepartment() + "\t" + 
					emp.getAge());  
			}
		}
	}
}
