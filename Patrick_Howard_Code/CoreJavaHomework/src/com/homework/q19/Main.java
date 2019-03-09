package com.homework.q19;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();

		for (int i = 1; i <= 10; i++) {			//counts from 1 to 10
			numbers.add(i);
		}
		System.out.println(numbers);			//prints out the array 1 through 10
		int evenTotal = 0;
		int oddTotal = 0;
		for (int j = 1; j <= numbers.size(); j++) {
			if (j % 2 == 0) {		
				evenTotal += j;			// pull the even numbers out and adds them
			} else {
				oddTotal += j;			// pull the odd numbers out and adds them
			}
		}
		System.out.println("Total even numbers are: " + evenTotal);
		System.out.println("Total odd numbers are: " + oddTotal);

		for (int j = 1; j < numbers.size(); j++) {
			int temp = numbers.get(j);				//pulls each number out and checks for prime value
			boolean notPrime = false;
			for (int k = 2; k <= temp / 2; ++k) {
				if (temp % k == 0) {				//separates the prime value
					notPrime = true;
					break;
				}
			}

			if (!notPrime) {
				primeNumbers.add(temp);				//places prime value into arraylist
			}

		}
		for (int x = 0; x < primeNumbers.size(); x++) {				
			numbers.remove(Integer.valueOf(primeNumbers.get(x)));	//Checks for elements in primeNumbers array list and removes them from numbers array
		}	
		System.out.println(numbers);

	}

}
