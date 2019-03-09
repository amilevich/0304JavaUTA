package com.homework.q18;

public class SubClass extends SuperClass{

	
	//the overridden method that checks if a character is uppercase
	@Override
	public boolean upperCase(String uC) {
		
		if(uC.toUpperCase() != null) {
				return true;
		}else {
			return false; 
		}
	}

	//the overridden method that changes all lowercase to uppercase 
	@Override
	public String lowerToUpper(String n) {
		
		
		return n.toUpperCase();
		
	}

	//the overridden method that converts a string to an int and adds 10  
	@Override
	public int stringToInt(String sI) {
	
		int sum = 0; 
		for(char c : sI.toCharArray()) {
			sum += c;
		}
		return sum + 10;
	}
	


}
