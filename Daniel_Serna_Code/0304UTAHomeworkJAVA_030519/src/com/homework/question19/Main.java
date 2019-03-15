package com.homework.question19;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		// Q19. Create an ArrayList and insert integers 1 through 10. 
		//
		// Display the ArrayList. 
		//
		// Add all the even numbers up and display the result. 
		// 
		// Add all the odd numbers up and display the result. 
		//
		// Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
		
		// create the arraylist
		ArrayList<Integer> myAL = new ArrayList<Integer>(10); 
		
		// put 1 to 10 into arraylist
		for(int i = 0; i < 10; i++)
		{
			myAL.add(i+1); 
		}
		
		// display arraylist
		System.out.println("ArrayList myAL: "+myAL);
		
		int temp = 0; // will hold sum of all even numbers in myAL
		
		// display the total of all even numbers
		for(int i = 0; i < myAL.size(); i++) 
		{
			// cast my object as an int
			if( (int)myAL.get(i) % 2 == 0)
			{
				temp += (int) myAL.get(i); 
			}
		}
		
		// display total of all even numbers
		System.out.println("Total of all even numbers: "+temp);
		
		temp = 0; // initialize temp back to 0
		
		// display the total of all odd numbers
		for(int i = 0; i < myAL.size(); i++) 
		{
			// cast my object as an int
			if( (int)myAL.get(i) % 2 == 1)
			{
				temp += (int) myAL.get(i); 
			}
		}
		
		// display total of all odd numbers
		System.out.println("Total of all odd numbers: "+temp);
		
		// reset temp to 0
		temp = 0; 
		// create boolean to find prime
		boolean t = false; 
		boolean primeBool = false; 
		
		// for loop to iterate through arrayList myAL and remove prime numbers
		// change i to 1 since 1 is not a prime number
		for(int i = 0; i < myAL.size(); i++)
		{		
			primeBool = isPrime(myAL.get(i)); 
			
			// remove prime if statem
			if(primeBool == true)
			{
				myAL.remove(i); 
				i = -1; 
			}
		}
		
		// display arraylist myAL
		System.out.println(myAL);
	}

	static boolean isPrime(Integer o) 
	{
		// starting from two up to the number itself
		// if anything modded by i, whatever is in the loop, 
		// if the integer modded up to the number is equivalent to zero then return false,, it is devisiable
		// else remove in other for
		
		for(int i = 2; i < o; i++)
		{
			if(o % i == 0)
			{
				return false; 
			}
		}
		
		return true; 
		
	}

}
