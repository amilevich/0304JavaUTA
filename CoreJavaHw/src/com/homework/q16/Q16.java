package com.homework.q16;

public class Q16 {
	
	public static void main(String[] args) {
		
		//conditional statement to check if characters were submitted to the command line
			//if found prints the length of the characters submitted 
		if(args.length > 0)
			System.out.println(args[0].length());
		else
			System.out.println("no command line arguments");
		
		}
	}


