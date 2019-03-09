package com.homework.q19;

import java.util.ArrayList;

public class Q19 {
	
	//method used to check if a number is a prime
	static boolean isPrime(int n) {
		
		//because 2 is the only even prime
		if(n==2) {
			return true;
		}
		
		
	
		for(int i = 2; i < n; i++) {
			if(n%i == 0)
				return false;
		}return true;
		}
	 
	
	public static void main(String[] args) {
	
	//create ArrayList to hold 1 to 10
	ArrayList<Integer> numbers = new ArrayList<Integer>();
	
	//adding 1 to 10 to the ArrayList
	for(int i = 1; i <= 10; i++)
		numbers.add(i);
	
		//print out ArrayList
		System.out.println(numbers);
	
		
		//loops through the arrayList and give the sum of our even numbers
		int evenSum = 0; 
		for(int i = 0; i < numbers.size(); i++)
		
		if(numbers.get(i)%2 == 0) {
			evenSum += numbers.get(i); 
			
		}
		System.out.println(evenSum);
		
		
		//loops through the arrayList and give the sum of the odd numbers
		int oddSum = 0; 
		for(int i = 0; i < numbers.size(); i++)
			
			if(numbers.get(i)%2 != 0) {
				oddSum += numbers.get(i); 
				
			}
			System.out.println(oddSum);
			
		
			//loops through the arrayList and removes the prime numbers
			for(int i = 0; i < numbers.size(); i++)
				if(isPrime(numbers.get(i))) {
					numbers.remove((i));
					i = -1; 
				}
			System.out.println(numbers);
			
		}}
			
			
