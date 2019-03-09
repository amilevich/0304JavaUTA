package homework.q15;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		MathExample m = new MathExample();
		
		//get first integer from the user
		System.out.println("Enter an float: ");
		Scanner sc = new Scanner(System.in);
		float a = sc.nextFloat();
		
		//get second integer from the user
		System.out.println("Enter another float: ");
		float b = sc.nextFloat();
		
		System.out.println("a = " + a + ", b = " + b);
		
		//perform the operations
		System.out.println("a + b = " + m.addition(a, b));
		System.out.println("a - b = " + m.subtraction(a, b));
		System.out.println("a * b = " + m.multiplication(a, b));
		System.out.println("a / b = " + m.division(a, b));
		
	}

}
