package Bank;

import java.util.Scanner;


public class User {

	String username;
	String password;
	String First;
	String Last;
	
	
	
	public User(String username, String password, String first, String last) {
		super();
		this.username = username;
		this.password = password;
		First = first;
		Last = last;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFirst() {
		return First;
	}



	public void setFirst(String first) {
		First = first;
	}



	public String getLast() {
		return Last;
	}



	public void setLast(String last) {
		Last = last;
	}



	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", First=" + First + ", Last=" + Last
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}



	void ViewMenu(Bank Ybank) {
		String greeting = "Greetings, User. Please select from the following: " + "\n1.Create Account" + "\n2.View Account" + "\n3.Make Withdrawel" + "\n4.Transfer Funds" + "\n5.Approval" + "\n6.Logout" ;
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
		case 5: System.out.println("Approval");
		break;
		case 6:System.out.println("Logged Out");
		break;
		case 7: System.out.println("Default");
		break;
			
		
		}
		
		
		
	}
				
	}
	
	