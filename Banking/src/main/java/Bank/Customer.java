package Bank;

import java.util.Scanner;

public class Customer extends User {

	public Customer(String username, String password, String first, String last) {
		super(username, password, first, last);
	}

	public static void main(String[] args) {

	}
	@Override
	void ViewMenu(Bank Ybank) {
		String greeting = "Greetings, User. Please select from the following: " + "\n1.Create Account" + "\n2.View Account" + "\n3.Make Withdrawel" + "\n4.Transfer Funds" + "\n5.Logout" ;
		System.out.println(greeting);
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		switch(i) {
		case 1: System.out.println("Enter starting balance:");
		double startingbalance = scanner.nextDouble();
		
		break;
		case 2: System.out.println("View Account");
		break;
		case 3: System.out.println("Withdraw");
		double withdrawelamount = scanner.nextDouble();
		break;
		case 4: System.out.println("Transfer Amount?");
		double transferamount = scanner.nextDouble();
		break;
		case 5:System.out.println("Logged Out");
		break;
		default: System.out.println("Default");
		break;
			
		
		}
		
		
		
	}
}
