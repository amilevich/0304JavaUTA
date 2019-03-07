package Question7;

import java.util.Comparator;

public class sortDepartment implements Comparator<Employee>{//Department sort class that implements the Comparator class

	public int compare(Employee a, Employee b) { //compare two variables 
		return a.getDepartment().compareTo(b.getDepartment()); //return the employee in ascending order
	}
}
