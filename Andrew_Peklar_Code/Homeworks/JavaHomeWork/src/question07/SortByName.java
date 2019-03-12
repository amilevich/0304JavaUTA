package question07;

import java.util.Comparator;

public class SortByName implements Comparator<Employee> {

	@Override
	public int compare(Employee a, Employee b) {
		//converted char to string in order to show 
		//how to handle strings with compareTo() method. 
		String aName = Character.toString(a.getName());
		String bName = Character.toString(b.getName());
		return aName.compareTo(bName);
	}

}
