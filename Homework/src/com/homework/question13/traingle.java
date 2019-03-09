package com.homework.question13;

public class traingle {

	public static void main(String[] args) {

		int x = 0; //sets up integers.
		int y = 1;

		boolean zero = true; //initializing boolean to true
for (int i = 1; i <= 4; i++) { //set up the loop
	//System.out.println(i);
	
			for (int j = 0; j < i; j++) { //set up the loop for the horizontal
				if (zero) 
					System.out.print(x + " ");
				else
					System.out.print(y + " ");

				zero = !zero; //
			}
			System.out.println(" ");
		}
	}
}
