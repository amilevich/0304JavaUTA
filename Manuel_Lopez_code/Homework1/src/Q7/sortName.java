package Q7;

import java.util.Comparator;

public class sortName implements Comparator<Employee>{	//name sort class that implement Comparator class
	public int compare(Employee x, Employee y) {
		return x.getName().compareTo(y.getName());		//return employee's names in order
	}
}
