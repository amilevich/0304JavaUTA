package com.problem17;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter principal"); // enter principal
		float principal = myObj.nextFloat(); //reads the input
		
		Scanner myObj2 = new Scanner(System.in);  
		System.out.println("Enter rate at as decimal. 20% would be 0.2"); //enter rate
		float rate = myObj.nextFloat();
		
		Scanner myObj3 = new Scanner(System.in);  
		System.out.println("Enter time"); //enter time
		int time = myObj.nextInt();
		
		float interest = principal * rate * time;
		System.out.println("Your interest is: " + interest);

	}

}
