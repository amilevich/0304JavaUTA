package Question17;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("To calculate simple interest first enter the principal amount.");
		int principal = scan.nextInt();
		System.out.println("Please enter the rate");
		double rate = scan.nextDouble();
		System.out.println("Please enter the time");
		int time = scan.nextInt();
		
		double interest = principal * rate * time;
		
		System.out.println("Okay, the simple interest comes out to: " + interest);
		
		
	}

}
