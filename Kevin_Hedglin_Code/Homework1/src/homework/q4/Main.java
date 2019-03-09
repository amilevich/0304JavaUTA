package homework.q4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//take in the number from the user
		System.out.println("N = ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		
		//get and print factorial
		Long factorial = getFactorial(i);
		System.out.println(i + "! = " + factorial);

	}

	public static Long getFactorial(int i)
	{
		Long l = new Long(i);
		
		for(int j = i - 1; j > 0; j--)
		{
			l *= j;
		}
		return l;
	}
}
