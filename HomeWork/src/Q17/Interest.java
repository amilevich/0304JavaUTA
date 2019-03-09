package Q17;

import java.util.Scanner;

public class Interest {
	static Scanner scan = new Scanner(System.in);//Instantiates the scanner
	public static void main (String [] args) 
	{
		System.out.println("Enter principal");
		float p = scan.nextFloat();//read user input
		
		System.out.println("Enter Rate of Interest");
		float r = scan.nextFloat();//read user input
		
		System.out.println("Enter number of years");
		int t = scan.nextInt();//read user input
		scan.close();//closes scanner
		
		System.out.println();
		System.out.println("Youre interest");
		
		float interest = p*r*t;//does math using the user input variables
		System.out.println(interest + "%");
		
	}
}
