package com.homework.question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q7 
{
	
	public static void main(String[] args)
	{
		ArrayList<Employee> eList = new ArrayList<Employee>();
		
		eList.add(new Employee("LeRoy","Memes", 69));
		eList.add(new Employee("Jenkins","!Memes", 42));
		
		//Makes comparators for each field
		Comparator<Employee> NameComparator =(x,y)->
		{return x.getName().compareTo(y.getName());};
		
		Comparator<Employee> DepartmentComparator =(x,y)->
		{return x.getDepartment().compareTo(y.getDepartment());};
		
		Comparator<Employee> AgeComparator =(x,y)->
		{return new Integer(x.getAge()).compareTo(new Integer(y.getAge()));};
		
		System.out.println("***Unsorted***");
		for (int i = 0; i < eList.size(); i++)
			System.out.println(eList.get(i).toString());
		
		
		Collections.sort(eList, NameComparator);
		
		System.out.println("***Sorted By Name***");
		for (int i = 0; i < eList.size(); i++)
			System.out.println(eList.get(i).toString());
		
		Collections.sort(eList,DepartmentComparator);
		
		System.out.println("***Sorted By Department***");
		for (int i = 0; i < eList.size(); i++)
			System.out.println(eList.get(i).toString());
		
		Collections.sort(eList, AgeComparator);
		
		System.out.println("***Sorted By Age***");
		for (int i = 0; i < eList.size(); i++)
			System.out.println(eList.get(i).toString());
	}
}
