package com.homework.Q18;

// Extend abstract class
public class Q18CL extends Q18Ab{

	@Override
	boolean CheckUpper(String UP) {
		// convert to character array
		char[] Check = UP.toCharArray();
		
		// loop length of array
		 for(int T=0; T < Check.length; T++){
	            
	          	// if uppercase is detected return true
	            if( Character.isUpperCase( Check[T] ))
	                return true;
		 }
	        
		// return false if uppercase was not detected
		return false;
	}

	@Override
	String ConvertUpper(String UP) {
		// convert to character array
		char[] Check = UP.toCharArray();
		
		// loop for length of character array
		for(int T=0; T < Check.length; T++) {
			 
			// Change characters to uppercase
			Check[T]= Character.toUpperCase(Check[T]);
			// save array to String
			UP = new String(Check) ;
	    }
		
		// Return String
		return UP;
	}

	
	@Override
	int ConvertInt(String Num) {
		
		// Convert string to integer
		int Conv = Integer.parseInt(Num);
		// Add ten
		Conv = Conv + 10;
		
		// return result
		return Conv;
	}

}
