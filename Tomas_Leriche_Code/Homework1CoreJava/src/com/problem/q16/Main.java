package com.problem.q16;


// run in command line from bin folder and java com.problem.q16.Main hello
public class Main {
	public static void main(String[] args) {
		if (args.length > 0) {
			System.out.println("The command line arguments are: ");

			for (String val : args) {
				System.out.println(val);
				System.out.println("length of string is: " + val.length());
			}
		} else
			System.out.println("no command line args");

	}
}