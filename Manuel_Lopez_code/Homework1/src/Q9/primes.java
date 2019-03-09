package Q9;

import java.util.Arrays;

public class primes {
	static int[] list = new int[100];								//array to be used

	public static void main(String[] args) {
		createList();												//call create list method
		//System.out.println(Arrays.toString(list));				//prints full list of 1 though 100
		printPrime();												//call printPrime method
	}

	static void createList() {										//
		for(int i=1; i <=100; i++)									//<- method to create list of numbers 1 to 100
			list[i-1]= i;											//
	}
	
	static void printPrime() {										//<- method to check for prime numbers
		int num=0;													//
		String primeNum="";											//<- string of prime numbers
																	//
		for(int x=1; x<=100; x++) {									//<- iterate through list of 100 numbers
			int y=0;												//
			for(num=x; num>=1; num--) {								//<- check if number is prime algorithm
				if(x%num==0)										//<- check if number is prime algorithm
					y = y+1;										//<- if number is prime set y equal to 2
			}														//
			if(y==2)												//<-If number is prime add to string prime
				primeNum = primeNum+x+", ";							//<-appending new prime number to string prime
		}															//
		System.out.println("Prime numbers are: "+primeNum);			//<- print list of prime numbers
	}
}
