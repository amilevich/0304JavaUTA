package Q14;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

public class swtch {

	public static void main(String[] args) {
		switchCase(3);																		//call switchCase method with 3 case options
	}
	
	static void switchCase(int x) {
		try(Scanner scan = new Scanner(System.in))											//try to ask for integer input from user
		{
			switch(x) {
			case 1:																			//
				System.out.print("Enter a number: ");										//case1 asking for number to square root
				int temp = scan.nextInt();													//
				System.out.println("The square root of "+temp+ " is "+Math.sqrt(temp));		//
				break;																		
			case 2:
				DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");			//
				LocalDate localDate = LocalDate.now();										//case2 to print todays date
				System.out.println("Today's date is "+date.format(localDate));				//
				break;																	
			case 3:
				String str = "I am Learning Core Java";										//
				String[] arr = str.split("\\s");											//case3 to split string into array
				for(String s:arr)															//
					System.out.println(s);													//
				break;
				
			}
		}
		catch(Exception e) {																//catch exception for scanner
			e.printStackTrace();															//
		}																					//
	}

}
