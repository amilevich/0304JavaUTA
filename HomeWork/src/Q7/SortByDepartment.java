package Q7;
import java.util.Comparator;

public class SortByDepartment implements Comparator<Employee> {
	
	@Override
	public int compare(Employee a, Employee b) 
	{
		return a.department.compareTo(b.department); 
		//checks to see if strings are equal or different
	}

}
