package Q2;

import java.util.ArrayList;

public class Fibo {
	static int limit = 25;
	static Integer start = 0; //first number in pattern, third to last value holder
	static Integer next = 1; //second number in pattern, second to last value holder
	
	
	public static void main (String[] args) 
	{
		ArrayList<Integer> list = new ArrayList<Integer>(); //a List of Integer objects
		list.add(start); //Add first element into list
		list.add(next); //Add second value into list
		
		System.out.print("[ " + start + ", "+ next ); //first two elements printed on console
		for (int i = 0; i <= (limit - 2); i++) 
		{
			Integer cont = start + next; //creates latest Integer object to hold updated value by adding the previous two numbers
			list.add(cont); //adds the last Integer object to the List
			start = next; //value of second to last entry is pushed to the third to last holder variable
			next = cont; //value of latest entry is passed to the second to last variable holder 
			System.out.print(", " + cont);
		}
		
		System.out.print(" ]");
	}
}
