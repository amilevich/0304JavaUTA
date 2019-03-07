package Question7;

import java.util.ArrayList;
import java.util.Collections;

public class Comparator {

	public static void main(String[] args) {
			ArrayList<Employee> arrlist = new ArrayList<Employee>();  //create an arraylist with a bunch of employees
			arrlist.add(new Employee(22, "Bob", "Sales"));			  //add employees
			arrlist.add(new Employee(50, "Phyllis", "Tech"));
			arrlist.add(new Employee(30, "Albert", "HR"));
			arrlist.add(new Employee(45, "Alberto", "Tech"));
			arrlist.add(new Employee(33, "Catie", "Sales"));
			
			//--------------------------------------sorted by age------------------------------------------------
			System.out.println("Sort by Age");
			Collections.sort(arrlist, new sortAge());   //sort in ascending order
			for(int i = 0; i < arrlist.size(); i++) {
				System.out.println(arrlist.get(i));     //print
			}
			System.out.println();
			
			//--------------------------------------sorted by name-----------------------------------------------
			System.out.println("Sort by Name");
			Collections.sort(arrlist, new sortName());  //sort in ascending order
			for(int i = 0; i < arrlist.size(); i++) {
				System.out.println(arrlist.get(i));     //print
			}
			System.out.println();
			
			//--------------------------------------sorted by Department------------------------------------------
			System.out.println("Sort by Department");
			Collections.sort(arrlist, new sortDepartment());  //sort in ascending order
			for(int i = 0; i < arrlist.size(); i++) {
				System.out.println(arrlist.get(i));     //print
			}
	}

}
