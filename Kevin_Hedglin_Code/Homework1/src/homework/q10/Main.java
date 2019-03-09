package homework.q10;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//read integer A from user
		System.out.println("Enter Integer A: ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		//read integer B from user
		System.out.println("Enter Integer B: ");
		int b = sc.nextInt();
		
		int minimum = (a < b) ? a : b;
		
		System.out.println("minimum = " + minimum);
	}

}
