package com.homework.question17;

import java.util.Scanner;

public class Interest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Principal");
		 Float principal =scanner.nextFloat();
		 
		 System.out.println("Rate");
			 Float rate =scanner.nextFloat();
			 
			 System.out.println("Time");
			 Float time =scanner.nextFloat();
			 
			 System.out.println("Principal * Rate * Time = Interest "  );
			 System.out.println(principal + " * " + rate + " * " + time + " = " +((principal * rate * time)));
		 
		 
		
	}
	
}
