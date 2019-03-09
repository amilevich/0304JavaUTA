package Q7;

import java.util.ArrayList;
import java.util.Collections;

public class SortDriver {

	public static void main(String[] args) {
		
		ArrayList<Employee> DataB = new ArrayList<Employee>();//new ArrayList with instantiated employees
		DataB.add(new Employee("Bill","Purchasing",66));
		DataB.add(new Employee("Susan","IT",26));
		DataB.add(new Employee("Kiara","Legal",56));
		
		Collections.sort(DataB, new SortByAge());//sorts DataB arrayList by functions from instantiated classes
		Collections.sort(DataB, new SortByDepartment());
		
		for (int i = 0; i <DataB.size(); i++) 
		{
			System.out.println(DataB.get(i));
		}
		
		
	}

}
