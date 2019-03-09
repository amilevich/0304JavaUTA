package homework.q14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// take in the switch case from the use
		System.out.println("Enter an Integer: ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		
		switch(i)
		{
			
			case 1:
				// print the square root of 64
				int j = (int) Math.sqrt(64);
				System.out.println("The square root of 64 is: " + j);
				break;
			case 2:
				// print the date
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				System.out.println("The date is: " + dateFormat.format(date));
				break;
			case 3:
				// split the string and print out the pieces
				String s = "I am learning Core Java";
				String[] ar = s.split("", 10);
				for(int k = 0; k < ar.length; k++)
				{
					System.out.println(ar[k]);
				}
				break;
			default:
				break;
		}
	}

}
