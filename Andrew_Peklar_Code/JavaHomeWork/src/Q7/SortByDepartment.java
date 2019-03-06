package Q7;

import java.util.Comparator;

public class SortByDepartment implements Comparator<Employee> {

	@Override
	public int compare(Employee a, Employee b) {
		char aDept = a.getDepartment();
		char bDept = b.getDepartment();
		return aDept - bDept;
	}
}
