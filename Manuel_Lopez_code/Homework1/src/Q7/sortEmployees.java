package Q7;

import java.util.ArrayList;
import java.util.Collections;

public class sortEmployees {
	
	public static void main(String[] args) {
		ArrayList<Employee> list = new ArrayList<Employee>();		//create ArrayList list
		
		list.add(new Employee(42, "Tom", "IT"));					//
		list.add(new Employee(25, "Jerry", "Support"));				//
		list.add(new Employee(22, "Bjorn", "HR"));					//add list o employees
		list.add(new Employee(34, "Ragnar", "Tech"));				//
		list.add(new Employee(27, "Ivar", "Support"));				//
		
		
		System.out.println("Age Sort");								//sort by age
		Collections.sort(list, new sortAge());						//sort in order	
		for(int i=0; i<list.size(); i++) {							//
			System.out.println(list.get(i));						//print employee in order by age
		}															//
		System.out.println();										//
		
		
		System.out.println("Name Sort");							//sort by name
		Collections.sort(list, new sortName());						//sort in order
		for(int i=0; i<list.size(); i++) {							//
			System.out.println(list.get(i));						//print employee in order by name
		}															//
		System.out.println();										//
		
		
		System.out.println("Department Sort");						//sort by department
		Collections.sort(list, new sortDepartment());				//sort in order
		for(int i=0; i<list.size(); i++) {							//
			System.out.println(list.get(i));						//print employee in order by department
		}															//
		System.out.println();										//
		
		
		


	}
}
