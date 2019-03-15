package com.homework.question12;

public class Main {

	public static void main(String[] args) {
		// Q12. Write a program to store numbers from 1 to 100 
		// in an array. Print out all the even numbers from the 
		// array. Use the enhanced FOR loop for printing out the 
		// numbers. 
		
		int arr[] = new int[100]; // reserve space for arr array
		
		// insert into the arr
		for(int i = 0; i < 100; i++)
		{
			arr[i] = i+1; 
		}
		
		// enhanced for loop
		for(int a : arr)
		{
			// DO NOT USE arr[a] for condition checking
			if(a % 2 == 0)
				System.out.println(a); // DO NOT USE arr[a] for displaying
				
			
		}
		
		
	}

}
