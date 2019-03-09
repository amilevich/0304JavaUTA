package com.homework.q6;

public class Even {

	//method to check for an even number. returns true or false. 
	static boolean even(int n) {
		
		return ((n/2) * 2 == n);
		
	}
	
	public static void main(String[] args) {
		
		int n = 22;
		
		
		//conditional statement used to check even or odd
		if(even(n) != false)
			System.out.println(n + ": is even");
		else
			System.out.println("odd");
	}
}
