package com.homework.question9;

import java.util.ArrayList;

public class Prime {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> Numbers = new ArrayList<Integer>(); //Making ArrayList.
		
		for(int i=2; i<=100; i++) { //loops from 2 to 100
			boolean pri = true; //Setting up a boolean that triggers false on non-prime numbers.
			Numbers.add(i);//puts ith number into the ArrayList
			for(int k=2; k<i; k++) {//loops through numbers less than i.
				if(i%k == 0) {//this checks non-prime numbers.
				pri = false;//signals a non prime number.
				}
			}
			if(pri==true) {//signals prime numbers.
				System.out.print(i + " ");//prints prime numbers.
			}
//			System.out.println(Numbers);	
		}	
			
		
	}
	
	

}
