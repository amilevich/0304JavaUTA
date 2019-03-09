package homework.q19;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		//create array of 1 - 10
		for(int i = 0; i < 10; i++)
		{
			arr.add(i + 1);
		}
		
		System.out.println(arr.toString());
		
		//sum the even numbers
		int sumEvens = 0;
		for(int i : arr)
		{
			if(i % 2 == 0)
			{
				sumEvens += i; 
			}
		}
		
		System.out.println("Sum of all evens: " + sumEvens);
		
		//sum the odd numbers
		int sumOdds = 0;
		for(int i : arr)
		{
			if(i % 2 == 1)
			{
				sumOdds += i; 
			}
		}
		
		System.out.println("Sum of all odds: " + sumOdds);
		
		//remove all primes from the list
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int i : arr)
		{
			if(isPrime(i))
			{
				primes.add(i);
			}
		}
		arr.removeAll(primes);
		
		
		System.out.println("No Primes: " + arr);
	}
	
	//check if the number is a prime or not
	public static boolean isPrime(int num)
	{		
		if(num == 1)
		{
			return false;
		}
		boolean prime = true;
		int i = 2;
		while(i <= num/2)
		{
			if(num % i == 0)
			{
				prime = false;
				break;
			}
			++i;
		}
		return prime;
		
	}

}
