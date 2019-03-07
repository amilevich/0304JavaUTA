package com.corejava.q7;

import java.util.Comparator;

// Comparator Method sourced from
// 	https://www.javatpoint.com/Comparator-interface-in-collection-framework
public class NameComparator implements Comparator
{
	public int compare (Object ob1, Object ob2)
	{
		Employee emp1 = (Employee) ob1;
		Employee emp2 = (Employee) ob2;
		
		return emp1.getName().compareTo(emp2.getName());
	}
}