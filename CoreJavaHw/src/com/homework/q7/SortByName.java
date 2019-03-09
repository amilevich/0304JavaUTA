package com.homework.q7;

import java.util.Comparator;

public class SortByName implements Comparator<Employee>  {

	
	//method to sort employees by name
	@Override
	public int compare(Employee empOne, Employee empTwo) {
		
		return empOne.name.compareTo(empTwo.name);
	}
	
	

}
