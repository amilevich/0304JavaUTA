package Q7;

import java.util.Comparator;

public class sortDepartment implements Comparator<Employee>{	//department sort class that implements Comparator class
	public int compare(Employee x, Employee y) {
		return x.getDepartment().compareTo(y.getDepartment());	//returns employee's department in order
	}
}
