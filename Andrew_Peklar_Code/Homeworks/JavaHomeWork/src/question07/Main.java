package question07;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	private static int newAge;
	private static char newDept, newName;
	private static ArrayList<Employee> list = new ArrayList<Employee>();

	public static void main(String[] args) {
		employeeGenerator(3);
		testComparator(list);
		
		cleanList(); 
		employeeGenerator(5);
		testComparator(list);
	}
	
	private static void cleanList() {
		list.removeAll(list);
		list.trimToSize();
		System.out.println("\n\n");
	}

	//Randomly populate object list
	private static void employeeGenerator(int numEms) {
		int index = -1;
		Random r = new Random();
		while (++index != numEms) {
			newAge = r.nextInt(50) + 18;
			newDept = (char) (r.nextInt(5) + 'a');
			newName = (char) (r.nextInt(26) + 'a');
			list.add(new Employee(newName, newAge, newDept));
		}
	}
	
	//Self-note: case-specific way to bring in a Collection
	private static <T> void testComparator(ArrayList<Employee> list) {
		System.out.println("--------------Sort By Name--------------");
		Collections.sort(list, new SortByName());
		list.forEach(System.out::println);

		System.out.println("\n\n--------------Sort By Age---------------");
		Collections.sort(list, new SortByAge());
		list.forEach(System.out::println);

		System.out.println("\n\n--------------Sort By Dep.--------------");
		Collections.sort(list, new SortByDepartment());
		list.forEach(System.out::println);
	}

}
