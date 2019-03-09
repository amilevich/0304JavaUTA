package Q7;

import java.util.Comparator;

public class sortAge implements Comparator<Employee>{	//age sort that implements Comparator class
	public int compare(Employee x, Employee y) {
		return x.getAge() - y.getAge();					//return employee by age order
	}
}
