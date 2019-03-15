package com.homework.question13;

public class Main {

	public static void main(String[] args) {

		// Q13. Display the triangle on the console as follows 
		// using any type of loop.  Do NOT use a simple group of 
		// print statements to accomplish this. 
		// 
	    // 0 
	    // 1 0 
	    // 1 0 1 
	    // 0 1 0 1
		
		// this boolean used to alternate between 0 and 1
		boolean alternate = false; 
		
		for(int r = 0; r < 5; r++)
		{
			for(int c = 0; c < r; c++)
			{
				if(alternate == false)
				{
					System.out.print("0");
					alternate = true; 
				}
				else
				{
					System.out.print("1");
					alternate = false; 
				}
			} System.out.println(); 
		}
		
	}

}
