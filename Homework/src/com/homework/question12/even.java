package com.homework.question12;

public class even {
	public static void main(String[] args) {
		int[] home = new int[100];// an array which contains integers 1 to 100.
		for (int i = 1; i <= 100; i++) { //cycles through the array.
			home[i - 1] = i;// assigning a number 1 to 100 to the elements in the array.
		}
		for (int i : home) { //Performing a block of code for each integer stored in home.

			if (i % 2 == 0) { //checking even.
				System.out.println(i);//prints out even numbers.
			}
		}
	}
}
