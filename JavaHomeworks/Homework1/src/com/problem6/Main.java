package com.problem6;

public class Main {

	public static void main(String[] args) {
		System.out.println(isEven(33));
		System.out.println(isEven(106));
	}
	
	public static boolean isEven(int x) {
	if ((x/2) * 2 == x ) {
			return true;	//logic: if an even number is divided by two, it will still be a whole number. 	
	} else {				// so it will still be the same number when multiplied by 2. If an odd number is divided by two, it will be	
			return false; // a decimal, so a new number will be created if multiplied by two
	}}

}
