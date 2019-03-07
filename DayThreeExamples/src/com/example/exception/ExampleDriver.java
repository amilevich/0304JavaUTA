package com.example.exception;

public class ExampleDriver {

	public static void main(String[] args) {

		bankTransaction("Withdraw", 101);
	}

	static void bankTransaction(String action, double amount) {
		if (action.equals("Withdraw")) {
			try {
				withdraw(amount);
			} catch (WithdrawTooBigException e) {
				e.printStackTrace();
			} finally {
				// always executes except
				// hardware destroyed, System.exit(), or
				// fatal error
				System.out.println("*********in finally block*********");
			}
		}

	}

	public static void withdraw(double withdrawAmount) throws WithdrawTooBigException {

		double maxWithdrawAmount = 100;

		if (withdrawAmount > maxWithdrawAmount) {
			throw new WithdrawTooBigException(
					withdrawAmount + " exceeds the max withdraw limit of: " + maxWithdrawAmount);

		}
	}
}
