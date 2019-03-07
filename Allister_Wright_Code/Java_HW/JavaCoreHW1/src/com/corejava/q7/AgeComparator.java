package com.corejava.q7;

import java.util.Comparator;

//Comparator Method sourced from
//	https://www.javatpoint.com/Comparator-interface-in-collection-framework
public class AgeComparator implements Comparator
{
	public int compare (Object ob1, Object ob2)
	{
		Employee emp1 = (Employee) ob1;
		Employee emp2 = (Employee) ob2;
		
		// Return 0 if equal ages
		if(emp1.getAge()==emp2.getAge())
		{
			return 0;
		}
		// return 1 if emp1 is older
		else if(emp1.getAge()>emp2.getAge())
		{
			return 1;
		}
		// return -1 if emp2 is older
		else
		{
			return -1;
		}
	}
}