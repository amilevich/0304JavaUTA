package Question7;

import java.util.Comparator;

public class sortAge implements Comparator<Employee>{ //Age sort class that implements the Comparator class

	public int compare(Employee a, Employee b) { //compare two variables 
		return a.getAge() - b.getAge();			 //return the employee in ascending order
	}
}
