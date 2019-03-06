package com.example.problem3;

public class StringReverse {

	public static void main(String[] args) {

		String forwards = new String("this is the string I'm reversing");
		
		/*
		 * one swap is performed initially because forwards.substring(0,0)
		 * does not return the first element in the string 
		 */
		
		forwards = forwards.charAt(forwards.length() - 1) + forwards.substring(1, forwards.length() - 1)
				+ forwards.charAt(0);

		for (int i = 1; i < forwards.length() / 2; i++) {
			forwards = forwards.substring(0, i) + forwards.charAt(forwards.length() - i - 1) 
					+ forwards.substring(i + 1, forwards.length() - i - 1) + forwards.charAt(i)
					+ forwards.substring(forwards.length() - i, forwards.length());
		}

		System.out.println(forwards);
	}

}
