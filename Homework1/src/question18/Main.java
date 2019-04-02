//program prompts user to input three strings

package question18;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner inputString1 = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String firstString = inputString1.nextLine(); //stores whatever string user inputs into "firstString" String
		Dog dogString = new Dog(); //declare object of Dog class type
		dogString.method1(firstString); //use this syntax to use methods located inside Dog class
		
		
		Scanner inputString2 = new Scanner(System.in);
		System.out.print("Enter another string: ");
		String secondString = inputString2.nextLine();
		Dog dogString2 = new Dog();
		dogString2.method2(secondString);
		
		Scanner inputString3 = new Scanner(System.in);
		System.out.print("Enter a number: ");
		String thirdString = inputString3.nextLine();
		Dog dogString3 = new Dog();
		dogString3.method3(thirdString);
	}

}
