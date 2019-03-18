package com.bank.model;

public class Junction {

	private int jnUserAccountId;
	private int userId;
	private int accountId;
	private int isJointAccount;

	public Junction() {
	}

	public Junction(int userId, int accountId, int isJointAccount) {
		super();
		this.userId = userId;
		this.accountId = accountId;
		this.isJointAccount = isJointAccount;
	}

	public Junction(int jnUserAccountId, int userId, int accountId, int isJointAccount) {
		super();
		this.jnUserAccountId = jnUserAccountId;
		this.userId = userId;
		this.accountId = accountId;
		this.isJointAccount = isJointAccount;
	}

	public int getJnUserAccountId() {
		return jnUserAccountId;
	}

	public void setJnUserAccountId(int jnUserAccountId) {
		this.jnUserAccountId = jnUserAccountId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getIsJointAccount() {
		return isJointAccount;
	}

	public void setIsJointAccount(int isJointAccount) {
		this.isJointAccount = isJointAccount;
	}

}
