package com.homework.question7;



import java.util.Comparator;
import java.io.*; 

public class Employees {

	// attributes 
	String name, department;
	int age; 
	
	@Override
	public String toString() {
		return "Employees [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

	// constructor
	public Employees(int a, String n, String d)
	{
		this.age = a; 
		this.name = n; 
		this.department = d; 
	}

	
}

class SortByName implements Comparator<Employees>
{
	public int compare(Employees a, Employees b)
	{
		return a.name.compareTo(b.name); 
	}
}

class SortByDepartment implements Comparator<Employees>
{
	public int compare(Employees a, Employees b)
	{
		return a.department.compareTo(b.name);
	}
}

class SortByAge implements Comparator<Employees>
{
	public int compare(Employees a, Employees b)
	{
		return a.age - b.age; 
	}
}
