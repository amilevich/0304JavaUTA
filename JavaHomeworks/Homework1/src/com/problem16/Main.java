package com.problem16;

public class Main {

	public static void main(String[] args) {
		String stringArgument = args[0]; //args is a String array so we can pass in arguements of type string through the command line
		int counter= 0;
		for (int i=0; i<stringArgument.length(); i++) {
			counter ++;
		}
		
		System.out.println(counter);
	}

}
