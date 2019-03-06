package com.example.problem16;

public class CommandArgs {

	public static void main(String[] args) {
		for(String s: args) {
			System.out.println("the number of characters in string \"" + s +"\" is " + s.length() );
		}
	}

}
