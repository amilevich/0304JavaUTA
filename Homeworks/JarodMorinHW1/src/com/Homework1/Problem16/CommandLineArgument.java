package com.Homework1.Problem16;

public class CommandLineArgument {

	public static void main(String[] args) {	// I can pass arguments to main in this IDE by setting them
												// in run configuration
												// They can also be passed through the command line
		
		if(args.length != 0) {					// testing if args[] is empty or not
			System.out.println("Input is: " + args[0]);	// access command line arguments using args[]
														// the first element is in args[0]
			System.out.println("Number of characters in input is: " + args[0].length());
		}												// string length is printed
		else
			System.out.println("No command line arguments received."); 
	}

}
