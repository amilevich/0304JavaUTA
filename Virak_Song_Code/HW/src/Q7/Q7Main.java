package Q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q7Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Q7Emp> emp = new ArrayList<Q7Emp>();  // object iQ7n ArrayList
		emp.add(new Q7Emp("Mik","Finance", 25));
		emp.add(new Q7Emp("David","IT", 20));
		emp.add(new Q7Emp("John","Accounting", 30));
		emp.add(new Q7Emp("Kelly","HR", 70));
		
		display(emp); // call display method from ArrayList without short
		Collections.sort(emp); // sort by name using customer compare from class Q7Emp
		
		
		System.out.println("");
		System.out.println("Order by Name");
		display(emp);  // display again after sort to show the sort
		
		Collections.sort(emp, new Q7ByDep());
		
		System.out.println("");
		System.out.println("Order by Department");
		display(emp);  // display again after sort to show the sort
		
		
		Collections.sort(emp, new Q7ByAge()); 
		
		System.out.println("");
		System.out.println("Order by Age");
		display(emp);  // display again after sort to show the sort
		
		
	}
	
	static void display(List<Q7Emp> list) {  // show method 
		System.out.println("Students: ");
		for(Q7Emp student: list) {
			System.out.println(student);
		}
	}
	
	

}
