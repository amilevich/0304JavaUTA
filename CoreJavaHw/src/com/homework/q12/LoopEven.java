package com.homework.q12;

import java.util.ArrayList;

public class LoopEven {
	
	
	public static void main(String[] args) {
		
				//create ArrayList to hold 1 to 100
				ArrayList<Integer> numbers = new ArrayList<Integer>();
				
				//adding 1 to 100 to the ArrayList
				for(int i = 1; i <= 100; i++)
					numbers.add(i);
					
				
				
				//looping my ArrayList
				for(int n: numbers) {
					
					//checking to see if number is even if so prints 
					if(n%2 == 0) {
						System.out.println(n);
					}
				}
	}

}
