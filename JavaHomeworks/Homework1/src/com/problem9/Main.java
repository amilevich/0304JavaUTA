package com.problem9;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList <Integer> nums= new ArrayList <> (); 
		
		for (int i=1; i<=100; i++) { //adds 1-100 in the nums ArrayList
			nums.add(i);
		}
		
		for (int num: nums) {  //looping through each number in the ArrayList
			if(isPrime(num)) { //calling the isPrime method on each number to see if it returns false or true
				System.out.println(num); //if true, print out the number
			}
		}
	}
	
	public static boolean isPrime(int num) {
		for(int i=2; i<num; i++) { //logic: if it is divisible by another number between 1 and itself, it is not prime
			if(num % i ==0) {
				return false;
			}
		}
		
		return true;
	}

}
