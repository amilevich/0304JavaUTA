package com.Homework1.Problem12;

public class PrintEvens {

	static boolean isEven(int x) {
		if(x < 0)				// isEven method borrowed from my problem6 that returns true if a given int is even
			x = Math.abs(x);	
		
		if(x/2 == (x+1)/2)		
		{
			return true;
		}
		return false;			
	}
	
	
	public static void main(String[] args) {
		
		int[] hundredArray = new int[100];
		for(int i = 1; i <= 100; i++)	// 100 elements to add to the ArrayList
		{
			hundredArray[i-1] = i;		// Placing numbers 1 through 100 into array 
		}
		for(int x : hundredArray) {		// Enhanced for loop includes all elements in hundredArray
			if(isEven(x))				
				System.out.println(x);	// If any element is even, as indicated by the isEven method, it is printed
		}

	}

}
