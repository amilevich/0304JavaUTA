package com.Homework1.Problem6;

public class Even {

	
	static boolean isEven(int x) {
		if(x < 0)
			x = Math.abs(x);	// Negative numbers don't usually change the output, but x = -1 is a problem
								// I use absolute value to eliminate this case.
		
		if(x/2 == (x+1)/2)		// Using truncation, I can determine that an integer is even by
								// comparing the results of x/2 and (x+1)/2.
		{
			return true;		// If x is even, x/2 and (x+1)/2 will have the same result because
								// x+1 will be odd and the result after dividing by two will truncate
								// and "round down". The condition will be true and we will return true.
		}
		return false;			// if x is not even, the program will not return with true and will 
								// instead reach this line and return with false
	}
	
	public static void main(String[] args) {
		for(int i = -10; i < 11; i++)		// Test values -10 through 10 with isEven()
		{
			System.out.print(i + " is ");
			if(isEven(i))
				System.out.println("even");	
			else
				System.out.println("odd");
		}
	}

}
