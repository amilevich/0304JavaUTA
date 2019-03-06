package Q2;

import java.util.Arrays;

public class Fibonacci {
	
	public static void main(String[] args) {
		firstTwentFiveFibs();
	}
	//this method prints the first 25 fibonacchi numbers
	private static void firstTwentFiveFibs() {
		int tmp = -1;		//index var
		int array[] = {1, 2}; 	//array to hold answers
		System.out.println(1);	//print first output
		
		while(++tmp != 25) { 
			System.out.println(array[tmp&1]);
			//short-curcuit to check last bit of binary
			//two (2) indices that switch storing the new sum
			if ((tmp & 1) == 0)	array[0] = array[1] + array[0];
			else			array[1] = array[1] + array[0];	
		}
	}
}


