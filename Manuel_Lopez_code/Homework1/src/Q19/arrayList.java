package Q19;

import java.util.ArrayList;
import java.util.Iterator;

public class arrayList {
	public static ArrayList<Integer> list = new ArrayList<Integer>();		//create ArrayList list
	
	public static void main(String[] args) {
		createListAndPrint();												//call createListAndPrint method
		addEvenAndOdd();													//call addEvenAndOdd method to add and print evens and odds
		printNonPrimes();													//call method to print non primes
	}
	
	public static void createListAndPrint() {
		for(int i=1; i<=10; i++) {											//
			list.add(i);													//method to fill arrayList with 1-10
		}																	//
		System.out.println(list);											//print arrayList
	}																		//
	
	public static Boolean even(int x) {										//method to check if integer is even
		if((x&1)==0) {														//use the bitwise operator to check if integer is even by looking at lowest order bit(first number in binary)
			//System.out.println("Number is even");							//if lowest order bit is 0 then number is even
			return true;													//
		}																	//
		else {																//
			//System.out.println("Number is odd"); 							//if lowest order bit is not 0 then number is odd
			return false;
		}		
	}
	
	public static void addEvenAndOdd() {									//
		int evenSum=0, oddSum=0;											//create int evenSum and oddSum
			for(int s : list ) {											//for loop to iterate through ArrayList list
				if(even(s)==true)											//if element in ArrayList list is even add to evenSum
					evenSum = evenSum+s;									//
				else
					oddSum = oddSum+s;
			}																//
			System.out.println("Even sum is: "+evenSum);					//print evenSum after exiting for loop
			System.out.println("Odd sum is: "+ oddSum);
	}
	
	public static boolean isPrime(int x) {									//
		for(int i=2; i<x; i++) {											//
			if(x%i == 0) {													//
				return false;												//method to check f integer is prime or not
			}																//
		}																	//
		return true;														//
	}																		//
	
	public static void printNonPrimes() {									//
		for(int x=0; x<list.size(); x++) {									//for loop to iterate through ArrayList list
			if(isPrime(list.get(x))) {										//checks each iteration for prime number
				list.remove(x);												//if integer is prime, remove from ArrayList list
			}																//
		}																	//
		list.remove(list.indexOf(2));										//remove special case of 2 from ArrayList list
		System.out.println(list);											//print ArrayList list
	}																		//

}
