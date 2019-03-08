//program prompts user to input principal, rate and time; then outputs interest

package question17;

import java.util.Scanner; //import this so user can input stuff

public class Interest {
	
	public static void main(String[] args) {
		
		Scanner inputPrincipal = new Scanner(System.in); //initializing "inputDouble" object
		System.out.print("Enter principal: ");		
		double userPrincipal = inputPrincipal.nextDouble();
		
		Scanner inputRate = new Scanner(System.in);
		System.out.print("Enter rate of interest: ");
		double userRate = inputRate.nextDouble();
		
		Scanner inputTime = new Scanner(System.in);
		System.out.print("Enter number of years: ");
		double userTime = inputTime.nextDouble();
		
		double userInterest = userPrincipal * userRate * userTime;
		System.out.println("Your interest is: " + userInterest);
		
	}

}
