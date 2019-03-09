package com.homework.question3;

public class Reverse {

	public static void main(String[] args) {
		String reverse = "Yousef the Pizzaman"; //creates a string.
		for(int i = 0; i < reverse.length(); i++) { //creates a for loop that runs length of the string.
			reverse = reverse.substring(1, reverse.length()-i) //moving the first element the right.
					+reverse.substring(0,1)                    //grab the first character in the string.
					+reverse.substring(reverse.length()-i, reverse.length()); //continues to the end of the reverse string length.
		}
		System.out.println(reverse);

	}

}
