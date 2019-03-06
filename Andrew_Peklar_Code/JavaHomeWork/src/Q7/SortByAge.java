package Q7;

import java.util.Comparator;

public class SortByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee a, Employee b) {
		int aAge = a.getAge();
		int bAge = b.getAge();
		return aAge - bAge;
	}

}
