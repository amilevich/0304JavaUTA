package Q2;

import java.util.Arrays;

public class Fibonacci {
	
	public static void main(String[] args) {
		firstTwentFiveFibs();
	}
	
	//this method prints the first 25 fibonacchi numbers
	//can be modified to print any number by adding a parameter
	//for the while statement.
	private static void firstTwentFiveFibs() {
		int tmp = -1;			//index var
		int array[] = {1, 2}; 	//array to hold answers
		System.out.println(1);	//print first output
		
		while(++tmp != 25) { 
			System.out.println(array[tmp&1]);
			//short-curcuit and checks last bit of binary
			//switches where new sum stored each loop
			if ((tmp & 1) == 0)	array[0] = array[1] + array[0];
			else				array[1] = array[1] + array[0];	
		}
	}
}


