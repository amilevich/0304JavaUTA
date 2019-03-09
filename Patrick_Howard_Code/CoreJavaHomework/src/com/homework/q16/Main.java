package com.homework.q16;

public class Main {

	public static void main(String[] args) {

		int x = 0;
		int i = 0;
		String ss;
		for (String s : args) {		//enhanced for loop for using command line arguments to make a string
			System.out.print(s);	
			x = s.length();
			i = i + x;				// Counts each character of the array

		}
		System.out.println(i);
	}

}