package question7;

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class Employee{
	String name;
	String department;
	int age;
	
	public Employee(String name, String department, int age) { //constructor
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String toString() {
		return this.name + " " +this.department + " " + this.age;
	}
}

class SortByName implements Comparator<Employee>{
	public int compare(Employee one, Employee two) {
		return one.name.compareTo(two.name);
	}
}

class SortByDepartment implements Comparator<Employee>{
	public int compare(Employee one, Employee two) {
		return one.department.compareTo(two.department);
	}
}

class SortByAge implements Comparator<Employee>{
	public int compare(Employee one, Employee two) {
		return one.age - two.age;
	}
}

//main class
public class ComparatorInterfaceSort {
	public static void main(String[] args) {
		ArrayList<Employee> employeeArray = new ArrayList<Employee>(); //declare, instantiate and initialize ArrayList
		employeeArray.add(new Employee("Jon", "Engineering", 18));
		employeeArray.add(new Employee("Dany", "Accounting", 34));
		employeeArray.add(new Employee("Brandon", "Psychology", 21));
		
		System.out.println("Original arrays:");
		for(int i = 0; i<employeeArray.size(); i++) {
			System.out.println(employeeArray.get(i));
		}
		System.out.println("");
		
		Collections.sort(employeeArray, new SortByName()); 
		System.out.println("Sorted by name:");
		for(int i = 0; i<employeeArray.size(); i++) {
			System.out.println(employeeArray.get(i));
		}
		System.out.println("");
		
		Collections.sort(employeeArray, new SortByDepartment()); 
		System.out.println("Sorted by department:");
		for(int i = 0; i<employeeArray.size(); i++) {
			System.out.println(employeeArray.get(i));
		}
		System.out.println("");		
		
		Collections.sort(employeeArray, new SortByAge()); 
        System.out.println("Sorted by age:"); 
        for (int i = 0; i<employeeArray.size(); i++) {
        	System.out.println(employeeArray.get(i)); 
        }
	}
}
