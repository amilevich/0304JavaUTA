package homework.q17;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//get the principle from the user
		System.out.println("Enter the principle(float): ");
		Scanner sc = new Scanner(System.in);
		float principle = sc.nextFloat();
		
		//get the rate of interest from the user
		System.out.println("Enter the rate of interest(float): ");
		float rate = sc.nextFloat();
		
		//get the time from the user
		System.out.println("Time(float): ");
		float time = sc.nextFloat();
		
		//calculate interest and print out result
		float interest = principle * rate * time;
		System.out.println(interest);
	}

}
