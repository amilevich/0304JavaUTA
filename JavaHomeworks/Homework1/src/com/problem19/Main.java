package com.problem19;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		ArrayList <Integer> nums= new ArrayList();
		ArrayList <Integer> noPrimes= new ArrayList();
		int counterOdd=0;
		int counterEven=0;
		
		for(int i=1; i<11; i++) { //added 1-10 to nums ArrayList
			nums.add(i);
		}
		
		for (int num:nums) {
			if (num%2 == 0) { //logic: loops through the array and checks if it is divisible by 2
				counterEven += num; //add that number to the even counter if that is the case
			}else {
				counterOdd += num; // add the number to the odd counter if not
			}
		}
		System.out.println(counterEven); //prints out the added even numbers
		System.out.println(counterOdd); //prints out the added odd numbers
		
		for (int num:nums) { // looping through nums and checking if each number is prime by calling the isPrime method
			if(!isPrime(num)) {  
				noPrimes.add(num); //if true, add to anotherArrayList
			}
		}
		
		System.out.println(noPrimes); //prints out arrayList without primes
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
