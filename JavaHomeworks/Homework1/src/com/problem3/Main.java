package com.problem3;

public class Main {

	public static void main(String[] args) {
		
		reverse("Helooo");
		
	}
	
	public static String reverse (String n) {
		String newString= "";
		for (int i=n.length()-1; i>=0; i--) {
			newString += n.charAt(i);
		}
		System.out.println(newString);
		return newString;
	}

}
