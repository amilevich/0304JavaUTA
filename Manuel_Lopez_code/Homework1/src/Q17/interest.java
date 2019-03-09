package Q17;

import java.util.Scanner;

public class interest {
	
	static int principal, rate, time, interest;											//principal, time, rate, interest variables
	
	public static void main(String[] args) {
		
		principal = getPrincipalAmount();												//get principal amount by calling getPrincipalAmount method
		rate = getRateAmount();															//get rate amount by calling getRateAmount method
		time = getTimeAmount();															//get time amount by calling getTimeAmount method
		interest = principal*rate*time;													//calculate interest by multiplying rate*time*principal
		System.out.println("Interest total is: "+interest);								//print interest amount
		
	}
	
	static int getPrincipalAmount() {													//	
		Scanner scan = new Scanner(System.in);											//
		System.out.print("Enter Principal Amount: ");									//method to get principal amount
		while(!scan.hasNextInt()) {														//keeps asking user for input if not integer
			System.out.print("Must eneter integer for principal amount: ");				//
			scan.next();																//
		}																				//
		int input = scan.nextInt();														//
		return input;																	//
	}
	
	static int getRateAmount() {														//
		Scanner scan = new Scanner(System.in);											//
		System.out.print("Enter Rate Amount: ");										//method to get rate amount
		while(!scan.hasNextInt()) {														//keeps asking user for input if not integer
			System.out.print("Must eneter integer for rate amount: ");					//
			scan.next();																//
		}																				//
		int input = scan.nextInt();														//
		return input;																	//
	}
	
	static int getTimeAmount() {														//
		Scanner scan = new Scanner(System.in);											//
		System.out.print("Enter Time Amount: ");										//method to get time amount
		while(!scan.hasNextInt()) {														//keeps asking user for input if not integer
			System.out.print("Must eneter integer for time amount: ");					//
			scan.next();																//
		}																				//
		int input = scan.nextInt();														//
		return input;																	//
	}
}
