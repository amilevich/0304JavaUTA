package com.problem.q14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	// you can enter 1, 2, 3, or 4 to exit
	public static int num;

	private static final DateFormat dform = new SimpleDateFormat("yyyy/MM/dd");

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter a Case number: \n " + " 1 or 2 or 3,  4 to exit: ");

		while (num != 4) {
			num = scan.nextInt();
			switch (num) {
			case 1:
				System.out.println("Enter a number to square root: ");
				int num2 = scan.nextInt();
				System.out.println(Math.sqrt(num2));
				break;
			case 2:
				Date date = new Date();
				System.out.println(dform.format(date));
				break;
			case 3:
				String string = new String("I am learning Core Java");
				String[] sa = new String[string.length()];

				// putting the string into the string array.
				sa = string.split("");
				ploop(sa);
				break;
			case 4:
				return;
			default:
				System.out.println("Must Enter a Case number: " + "\n 1 or 2 or 3,  4 to exit: ");
			}
		}
	}

	// a printing loop
	public static void ploop(String[] strArray) {
		for (String i : strArray) {
			System.out.print(i);
		}
		System.out.println("\nstrArray of length " + strArray.length);
	}
}
