package com.projectzero.main;

import java.util.InputMismatchException;

import com.projectzero.accounts.Account;
import com.projectzero.accounts.WithdrawTooBigException;

public class Banking {

	Banking() {
	}

	public static void banking(Account holder) throws WithdrawTooBigException {

		float amount;
		boolean b = false;

		do {
			try {
				System.out.println("\nYour account balance is \n$ " + holder.getAccountBalance()
						+ "\nWhat would you like to do?:" + "\n 1: Withdraw\n 2: Deposit\n 3: Transfer\n 4: Quit");
				Main.userName = holder.getUsername();

				switch (Main.sc.nextInt()) {
				case 1:
					System.out.print("Withdraw amount: \n$ ");
					amount = Main.sc.nextFloat();

					if (amount > 0) {
						holder.withdraw(amount);
						printTransaction("Withdrawal", "success", amount);
					} else {
						printTransaction("Withdrawal", "failure", amount);
					}
					break;

				case 2:
					System.out.print("Deposit amount: \n$ ");
					amount = Main.sc.nextFloat();
					if (amount > 0) {
						holder.deposit(amount);
						printTransaction("Deposit", "success", amount);
					} else {
						printTransaction("Deposit","failure", amount);
					}
					break;

				case 3:
					System.out.print("Username of account to transfer to: ");
					String to;
					to = Main.sc.next();

					System.out.print("Transfer amount: \n$ ");
					amount = Main.sc.nextFloat();

					if (amount > 0) {
						holder.transfer(amount, to);
						printTransaction(to, amount, "success");
					} else {
						printTransaction(to, amount, "failure");
					}
					break;

				case 4:
					b = false;
					Main.Quit();
					break;

				default:
					System.out.println("Try again!");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Try again!");
				banking(holder);
			}
		} while (!b);
	}

	public static void printTransaction(String transaction, String outcome, float amt) {
		Main.logger.info(
				transaction + " of $ " + Float.toString(amt) + " from account " + Main.userName + " was a " + outcome);
		System.out.println("\n" + transaction + " of $ " + amt + " " + outcome);
	}

	public static void printTransaction(String to, float amount, String outcome) {
		Main.logger.info("transfer of $ " + Float.toString(amount) + " from account " + Main.userName + " to account "
				+ to + " was a " + outcome);
		System.out.println("\nTransfer of $ " + amount + " to account " + to + " " + outcome);
	}
}
