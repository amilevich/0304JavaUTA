package Q12;

import java.util.ArrayList;

public class evenNums {

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>(); //new array

		for (int i = 1; i<= 100; i++) 
		{//from 1 - 100 you add
			array.add(i);
		}
		for (Integer i : array) 
		{
			if (i%2 == 0) {System.out.println(i);} //if element /2 doesnt return remainder, print
		}
	}

}
