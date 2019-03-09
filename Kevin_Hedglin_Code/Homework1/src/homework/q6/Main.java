package homework.q6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//take in an integer from the user
		System.out.println("Enter an Integer: ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		
		//check the integer for evenness and print the result
		if(isEven(i))
		{
			System.out.println("The integer is even.");
		}
		else
		{
			System.out.println("The integer is odd.");
		}
	}
	
	public static boolean isEven(int i)
	{
		
		//subtract 2 continuously until i is less than 2
		//if there is a remainder, then the number is odd
		while(i > 2)
		{
			i -= 2;
		}
		
		if(i == 1)
			return false;
		else
			return true;
	}

}
