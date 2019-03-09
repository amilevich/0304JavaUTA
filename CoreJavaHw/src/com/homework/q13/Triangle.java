package com.homework.q13;

public class Triangle {
	
	public static void main(String[] args) {
		
		int count = 1;
		
		//loops for 4 iterations to print out O and 1 in the triangle pattern 
		for(int i = 1; i <= 4; i++) {
			for(int j = 0; j < i; j++) {
				if(count%2 != 0) {
					System.out.print("0");
				}else {
					System.out.print("1");
				}
				count++;
			}
			System.out.print("\n");
		}
	}

}
