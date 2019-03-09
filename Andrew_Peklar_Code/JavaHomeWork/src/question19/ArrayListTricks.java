package question19;

import java.util.ArrayList;

public class ArrayListTricks {
	
	//create ArrayList
	private static ArrayList<Integer> aListy = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		fillList();		// fill list with integers 1-10
		displayList();		// display the list
		sumEvensList();		// sum of even numbers
		sumOddsList();		// sum of odd  numbers
		removePrimes();		// remove primes from list		
		displayList();		//display result of removing primes
	}

	private static void fillList() {
		int index = 0;
		while(++index != 11)	
			aListy.add(index);
	}
	
	private static void displayList() {
		System.out.println("Full list: \t\t" + aListy);
	}
	
	private static void sumEvensList() {
		int evenSum = aListy.stream()
				    .filter((x) -> (x&1) == 0)
				    .mapToInt(Integer::new)
				    .sum();
		System.out.println("Sum of even numbers: \t" + evenSum);
	}
	
	private static void sumOddsList() {
		int oddsSum = aListy.stream()
				    .filter((x) -> (x&1) == 1)
				    .mapToInt(Integer::new)
				    .sum();
		System.out.println("Sum of odd numbers : \t" + oddsSum);
	}
	
	private static void removePrimes() {
		aListy.removeIf(x -> isPrime(x));
	}
	
	private static boolean isPrime(int x) {
		//no primes are even except 2
		if(x > 2 && (x & 1) == 0)	return false;
		if(x < 2) return false;
		for (int fact = 2; fact*fact < x; fact++)
			if (x % fact == 0)	return false;
		return true;	
	}

}
