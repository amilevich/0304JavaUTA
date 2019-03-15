package com.projectzero.accounts;

import com.projectzero.accounts.WithdrawTooBigException;
import com.projectzero.users.User;

public class Account extends User implements Transactable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Account has balance and can have joint account holder name
	private float accountBalance;
	private String jointName;

	public Account(String username, String password, String firstName, String lastName, String ssn,
			float accountBalance) {
		super(username, password);
		this.accountBalance = accountBalance;
	}

	public Account(String username, String password, String firstName, String lastName, String ssn,
			float accountBalance, String jointName) {
		super(username, password);
		this.accountBalance = accountBalance;
		this.jointName = jointName;
	}

	//transactions methods written
	@Override
	public void withdraw(float wAmount) throws WithdrawTooBigException {

		if (wAmount > accountBalance)
			throw new WithdrawTooBigException(wAmount + " exceeds the max withdraw limit of : " + accountBalance);
		else
			accountBalance -= wAmount;

	}

	@Override
	public void deposit(float dAmount) {

		accountBalance += dAmount;

	}

	@Override
	public void transfer(float tAmount, String to) throws WithdrawTooBigException {

		if (tAmount > accountBalance) {
			throw new WithdrawTooBigException(tAmount + " exceeds the max withdraw limit of : " + accountBalance);

		}

		// set toUser Account to corresponding username in loginInfo hashmap
		Account toUser;

		if (loginInfo.get(to) instanceof Account) {
			toUser = (Account) loginInfo.get(username);
			accountBalance -= tAmount;
			toUser.deposit(tAmount);
		}
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getJointName() {
		return jointName;
	}

	public void setJointName(String jointName) {
		this.jointName = jointName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(accountBalance);
		result = prime * result + ((jointName == null) ? 0 : jointName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Float.floatToIntBits(accountBalance) != Float.floatToIntBits(other.accountBalance))
			return false;
		if (jointName == null) {
			if (other.jointName != null)
				return false;
		} else if (!jointName.equals(other.jointName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountBalance=" + accountBalance + ", accountHolders=" + jointName + "]";
	}

}
