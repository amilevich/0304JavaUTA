package Q7;

import java.util.Comparator;

public class SortByAge implements Comparator<Employee>{

	@Override //Overriden Comparator method
	public int compare(Employee a, Employee b) {
		return a.age - b.age; //returns 1,0,-1 depending on age value of two employees
	}

}
