package Question7;

import java.util.Comparator;

public class sortName implements Comparator<Employee>{ //Name sort class that implements the Comparator class

	public int compare(Employee a, Employee b) {   //compare two variables 
		return a.getName().compareTo(b.getName()); //return the employee in ascending order
	}

}
