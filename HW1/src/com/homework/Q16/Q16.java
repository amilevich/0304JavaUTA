package com.homework.Q16;
/*
 * Christopher Collins
 * Display characters from input string
 * NOTE: only works with Run Configurations
 */

public class Q16 {

	public static void main(String[] args)
	{
		
		// get string and store it
		String T = args[0];
		
		// Loop to print out characters in string
	    for(int i = 0; i< T.length(); i++) 
	    {
	      System.out.println( T.charAt(i) );
	    }
	}

}
