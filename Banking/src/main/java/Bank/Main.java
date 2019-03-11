package Bank;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Bank Ybank = new Bank();
		Ybank.employeegen("Yos", "Poo", "Yousef", "Mohammed");
		for (String You : Ybank.UserMap.keySet())
			System.out.println(Ybank.UserMap.get(You));

		while (true) {
			start(Ybank);
		}

	}

	static void start(Bank Ybank) {
		String greeting = "Welcome to the International Bank of Yousef" + "\n1.Login" + "\n2.Register";
		System.out.println(greeting);
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt(); // fix the exception for input mismatch.
		switch (i) {
		case 1:
			// System.out.println("Login");
			System.out.println("Enter username, please");
			String usernameinput = scanner.next();
			if (Ybank.UserMap.keySet().contains(usernameinput)) {
				System.out.println("Enter password, please");
				String passinput = scanner.next();
				if (Ybank.UserMap.get(usernameinput).getPassword().equals(passinput)) {
					//System.out.println("Great Job!");
					Ybank.UserMap.get(usernameinput).ViewMenu(Ybank);
				}
				else
					System.out.println("Invalid, try again");
			} else {
				System.out.println("Invalid username, please register");
			}

			break;

		case 2:
			// System.out.println("Register");

			System.out.println("Enter your desired username:");
			String k;
			while (true) {
				k = scanner.next();
				if (Ybank.UserMap.keySet().contains(k)) {
					System.out.println("User already exists. Try Again.");
					continue;
				}
				break;
			}
			System.out.println("Enter your desired password");
			String p = scanner.next();
			System.out.println("Enter your First Name");
			String g = scanner.next();
			System.out.println("Enter your Last Name");
			String t = scanner.next();
			System.out.println("Thanks, please login and request an account");
			Ybank.usergen(k, p, g, t);
		default:
			System.out.println("Invalid Input");
			// for (String You : Ybank.UserMap.keySet())
			// System.out.println(Ybank.UserMap.get(You));
		}

	}
}
