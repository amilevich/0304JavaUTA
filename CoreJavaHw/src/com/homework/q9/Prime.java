package com.homework.q9;

import java.util.ArrayList;

public class Prime {
	
	public static void main(String[] args) {
		
		//create ArrayList to hold 1 to 100
		ArrayList<Integer> myNumbers = new ArrayList<Integer>();
		
		//adding 1 to 100 to the ArrayList
		for(int i = 1; i <= 100; i++)
			myNumbers.add(i);
			//System.out.println(myNumbers);
		
		
		//looping my ArrayList
		for(int n: myNumbers) {	
			
			boolean isPrime = true;
			
			//loops through the arrayList to check if a number is prime
			for(int i = 2; i < n; i++)
				if(n%i == 0) isPrime = false;
			
			
				if(isPrime) {
				System.out.println(n + " " );
				
			}
		}
		
		
	}

}