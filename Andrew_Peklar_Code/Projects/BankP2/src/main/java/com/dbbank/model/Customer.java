package com.dbbank.model;

public class Customer {
	
	Integer customerID = null;		//if null, then not approved
	String 	cFirstName, cLastName;
	
	public Customer() {}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}


	public String getcFirstName() {
		return cFirstName;
	}

	public void setcFirstName(String cFirstName) {
		this.cFirstName = cFirstName;
	}

	public String getcLastName() {
		return cLastName;
	}

	public void setcLastName(String cLastName) {
		this.cLastName = cLastName;
	}

//	@Override
//	public String toString() {
//		return "Customers [customerID=" + customerID + ", loginName=" + loginName + ", loginPass=" + loginPass
//				+ ", cFirstName=" + cFirstName + ", cLastName=" + cLastName + "]";
//	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", cFirstName=" + cFirstName + ", cLastName=" + cLastName + "]";
	}

	public Customer(Integer customerID, String cFirstName, String cLastName) {
		super();
		this.customerID = customerID;
		this.cFirstName = cFirstName;
		this.cLastName = cLastName;
	}
}
