package com.problem10;

public class Main {

	public static void main(String[] args) {
		System.out.println(minimum(9,15));

	}
	
	public static int minimum(int a, int b) {
		int x = a > b ? b : a ; //checking if a is greater than b, return b if it is. If not, return a	
		return x;
	}

}
