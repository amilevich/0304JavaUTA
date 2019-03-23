package com.projectone.models;

import java.sql.Timestamp;
import java.util.Arrays;

public class Reimbursement {
	private Integer reimbId;
	private Double reimbAmount;
	private Timestamp reimbSubmitted;
	private Timestamp reimbResolved;
	private String reimbDescription;
	private Byte[] reimbReceipt;
	private Integer reimbAuthor;
	private Integer reimbResolver;
	private Integer reimbStatusId;
	private Integer reimbTypeId;
	
	public Reimbursement() {
	}

	public Integer getReimbId() {
		return reimbId;
	}

	public void setReimbId(Integer reimbId) {
		this.reimbId = reimbId;
	}

	public Double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(Double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public Timestamp getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public Byte[] getReimbReceipt() {
		return reimbReceipt;
	}

	public void setReimbReceipt(Byte[] reimbReceipt) {
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

	public Reimbursement(Integer reimbId, Double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDescription, Byte[] reimbReceipt, Integer reimbAuthor, Integer reimbResolver,
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
	
	
}
