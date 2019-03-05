package com.example.strings;

public class Main {

	// difference between stack and heap
	// both are parts of the Java Memory Model (JMM)
	// heap -> where all objects are stored
	// stack -> methods, parameters, return types, variables, etc

	public static void main(String[] args) {



//		if (stringOne == "BirdPerson") {
//			System.out.println("inside if statement");
//		}
		// since BirdPerson was created using "new"
		// keyword, this is false
		// if BirdPerson is a string literal, the if
		// statement is true
		
		 String stringOne = new String("BirdPerson");
		//String stringOne = "BirdPerson";
		
		if(stringOne.equals("BirdPerson")) {
//			System.out.println("dot equals statement");
		}
		// == -> checks memory location
		// .equals the actual value
		
		
		//strings are immutable
		String stringTwo = "Frank";
//		stringTwo.concat(" and Jimmy");
		// this will only print "Frank"
		
		stringTwo = stringTwo.concat(" and Jimmy");
		// this prints "Frank and Jimmy"
		
//		System.out.println(stringTwo);
		
		StringBuilder sBuilderOne = new StringBuilder("chimneytop");
		sBuilderOne.append(" and a platypus -_-");
		
//		System.out.println(sBuilderOne);
		// StringBuilder overrides the toString method
		// sBuilderOne can be changed, but strings cannot
		
		StringBuffer sBufferOne = new StringBuffer("Sticker");
		sBufferOne.append(" and a horse...");
		System.out.println(sBufferOne);
		
		// StringBuffer is safe but slower
		
	}

}
