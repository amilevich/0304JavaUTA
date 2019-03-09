package homework.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		//create employees
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("zaron", "science", 23));
		employees.add(new Employee("Lars", "science", 23));
		
		//sort employees
		Collections.sort(employees, new EmployeeComparator());
		
		//print employees in order
		for(Employee e : employees)
		{
			System.out.println(e);
		}
	}

}
