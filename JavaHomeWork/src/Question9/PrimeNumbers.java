package Question9;

import java.util.ArrayList;

public class PrimeNumbers {
	
	public static void main(String[] args) {
		
		//create arraylist
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		//loop from 2 -> 100
		for(int i = 1; i < 100; i++) { 
			isPrime(i); //prime check
			numbers.add(i); //add all numbers to arraylist
			
		}
		
	}
	public static void isPrime(int f) {
		boolean bo = true;	//Boolean checker
		if(f == 1) { 	//1 is not prime
			bo = false;
		}
		for(int i = 2; i < f; i++) { //loop so we can check all possible factors to make sure a value is prime
			if(f % i == 0) {      //if the modulo is 0 then the value is not prime
				bo = false;		  //so we set the boolean to false
			}
		}
		if(bo) { 		 //if it is prime based on our check
			System.out.println(f); //print
		}

	}
}