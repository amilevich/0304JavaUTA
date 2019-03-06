package com.example.problem2;

public class Fibbonacci {
	
	public static void main(String[] args) {
		
		int n = 0, j = 1,k;
		
		for(int i = 0; i < 26; i++) {
			System.out.println("The "+i+"'th number in the fibbonacci sequence is "+ n);
			k = n+j;
			n = j;
			j = k;
		}
		
	}

}
