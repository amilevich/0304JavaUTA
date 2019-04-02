package question19;

import java.util.ArrayList;

public class ArrayListEvenOdd {
	
	public static void main(String[] args) {
		ArrayList<Integer> numberArray = new ArrayList<Integer>();
		for(int i = 0; i<10; i++) {
			numberArray.add(i + 1); //inserting integers 1-10
		}
		System.out.println("Original array: " + numberArray);
		
		int evenVar = 0;
		int oddVar = 0;
		for(int j = 0; j<numberArray.size(); j++) {
			if(Math.floorMod(numberArray.get(j), 2) == 0) {
				evenVar = evenVar + numberArray.get(j);
			}
			else {
				oddVar = oddVar + numberArray.get(j);
			}
		}
		System.out.println("Even numbers added up: " + evenVar);
		System.out.println("Odd numbers added up: " + oddVar);
		
		ArrayList<Integer> primeArray = new ArrayList<Integer>();
		for(int i = 0; i<numberArray.size(); i++) {
			boolean isPrime = true;
			for(int j = 2; j<i; j++) {
				if (i%j==0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				numberArray.remove(i); //removes prime numbers
				primeArray.add(i);
			}
		}
		System.out.println("Prime numbers removed: " + primeArray);
		System.out.println("Final array: " + numberArray);
		
		
		/*
		for(int k = 2; k<numberArray.size(); k++) {
			if(numberArray.get(k) % k != 0) {
				numberArray.remove(k);
			}
			else {
				numberArray.remove(k);
			}
		}
		*/
		//System.out.println("Prime numbers removed: " + numberArray);
	}
		
}
//numberArray.remove(j); //removes element of ArrayList; in this case, it removes odd numbers
