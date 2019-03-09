package com.homework.question1102;

import com.homework.question1101.Main2;

public class Main1 {

	public static void main(String[] args) {

		// Q11. Write a program that would access two 
		// float-variables from a class that exists in another 
		// package. Note, you will need to create two packages 
		// to demonstrate the solution
		
		float a = Main2.getFirstFloat(); // make a function call to retrieve float point numbers
		float b = Main2.getSecondFloat(); 
		
		System.out.println("First float: "+a+" Second float: "+b);
	}

}
