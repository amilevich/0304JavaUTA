package question09;

import java.util.ArrayList;

//Create an ArrayList which stores numbers from 1 to 100 and 
//prints out all the prime numbers to the console.
public class FirstPrimesInOneHundered {
	
	private static  ArrayList<Integer> cList = new ArrayList<>(100);

	public static void main(String[] args) {
		
		//was not sure which way was desired
		allNums(); 
		cleanList();
		justPrimes();
	}
	
	private static void cleanList() {
		cList.removeAll(cList);
		cList.trimToSize();
		System.out.println("\n\n");
	}
	
	//just stores primes and prints them
	private static void justPrimes(){
		int index = 0;
		while(++index != 101)  
			if(isPrime(index) == true) cList.add(index);
		System.out.println("First 100 primes: " + cList);
	}
	
	//stores all vals 1-100 and prints primes
	public static void allNums() {
		int index = 0;
		System.out.print("First 100 primes: ");
		while(++index != 101) 	{
			if(isPrime(index) == true) System.out.print(index + ", ");
			cList.add(index);
		}
	}
	
	public static boolean isPrime(int x) {
		//no primes are even except 2
		if(x > 2 && (x & 1) == 0)	return false;
		if(x < 2) return false;
		for (int fact = 2; fact*fact < x; fact++)
			if (x % fact == 0)	return false;
		return true;	 
	}

}
