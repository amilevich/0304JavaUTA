package com.problem2;

public class Main {

	public static void main(String[] args) {
		for (int i=0; i<25; i++) {
			System.out.println(fibonacci(i));
		}
	
	}
	
	public static int fibonacci (int index) {
		if (index <= 1) {
			return index;
		}
		else {
			return fibonacci(index-1) + fibonacci(index-2);
		}
		
	}

}
