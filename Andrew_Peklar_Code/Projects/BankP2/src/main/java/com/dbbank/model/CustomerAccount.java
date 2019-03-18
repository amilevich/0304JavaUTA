package com.dbbank.model;

//enables joint accunts and ownwership of multiple accounts
public class CustomerAccount {
	
	Integer custID, AccId;
	
	public CustomerAccount() {}

	public Integer getCustID() {
		return custID;
	}

	public void setCustID(Integer custID) {
		this.custID = custID;
	}

	public Integer getAccId() {
		return AccId;
	}

	public void setAccId(Integer accId) {
		AccId = accId;
	}

	@Override
	public String toString() {
		return "CustomerAccounts [custID=" + custID + ", AccId=" + AccId + "]";
	}

	public CustomerAccount(Integer custID, Integer accId) {
		super();
		this.custID = custID;
		AccId = accId;
	}
}
