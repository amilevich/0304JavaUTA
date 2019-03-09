package homework.q18;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubClass sub = new SubClass();
		
		//get the string from the user
		System.out.println("Enter a string: ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		if(sub.checkForUpperCase(s))
		{
			System.out.println("The string you entered was upper case");
		}
		else
		{
			System.out.println("The string you entered was not upper case");
		}
		
		System.out.println("your string to upper case is : " + sub.toUpperCase(s));
		
		
		System.out.println("Enter an integer: ");
		s = Integer.toString(sc.nextInt());
		sub.addTen(s);
	}

}
