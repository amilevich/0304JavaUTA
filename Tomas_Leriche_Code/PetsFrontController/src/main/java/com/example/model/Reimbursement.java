package com.example.model;

import java.util.Arrays;

public class Reimbursement {

	// ERS_REIMNURSEMENT TABLE
	// REIMB_ID PRIMARY KEY ( NUMBER )
	// REIMB_AMOUNT ( NUMBER )
	// REIMB_SUBMITTED ( TIMESTAMP )
	// REIMB_RESOLVED ( TIMESTAMP )
	// REIMB_DESCRIPTION ( VARCHAR2(250) )
	// REIMB_RECEIPT ( BLOB )
	// REIMB_AUTHOR FOREIGN KEY ( NUMBER )
	// REIMB_RESOLVER FOREIGN KEY ( NUMBER )
	// REIMB_STATUS_ID FOREIGN KEY ( NUMBER )
	// REIMB_TYPE_ID FOREIGN KEY ( NUMBER )

	Integer reimbId;
	double reimbAmount;
	String reimbSubmitted;
	String reimbResolved;
	String reimbDescription;
	byte[] reimbReceipt;
	Integer reimbAuthor;
	Integer reimbResolver;
	Integer reimbStatusId;
	Integer reimbTypeId;

	public Reimbursement() {

	}

	public Reimbursement(Integer reimbId, double reimbAmount, String reimbSubmitted, String reimbResolved,
			String reimbDescription, byte[] reimbReceipt, Integer reimbAuthor, Integer reimbResolver,
			Integer reimbStatusId, Integer reimbTypeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
	}

	public Reimbursement(double reimbAmount, String reimbSubmitted, String reimbResolved, String reimbDescription,
			byte[] reimbReceipt, Integer reimbAuthor, Integer reimbResolver, Integer reimbStatusId,
			Integer reimbTypeId) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
	}

	public Integer getReimbId() {
		return reimbId;
	}

	public void setReimbId(Integer reimbId) {
		this.reimbId = reimbId;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public String getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(String reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public String getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(String reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public byte[] getReimbReceipt() {
		return reimbReceipt;
	}

	public void setReimbReceipt(byte[] reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}

	public Integer getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(Integer reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public Integer getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(Integer reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public Integer getReimbStatusId() {
		return reimbStatusId;
	}

	public void setReimbStatusId(Integer reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}

	public Integer getReimbTypeId() {
		return reimbTypeId;
	}

	public void setReimbTypeId(Integer reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbReceipt=" + Arrays.toString(reimbReceipt) + ", reimbAuthor=" + reimbAuthor
				+ ", reimbResolver=" + reimbResolver + ", reimbStatusId=" + reimbStatusId + ", reimbTypeId="
				+ reimbTypeId + "]";
	}
}
