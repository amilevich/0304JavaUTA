package com.projectone.models;

public class ReimbursementStatus {

	private Integer reimbStatusId;
	private String reimbStatus;
	
	public ReimbursementStatus() {
	}

	public Integer getReimbStatusId() {
		return reimbStatusId;
	}

	public void setReimbStatusId(Integer reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}

	public String getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	@Override
	public String toString() {
		return "ReimbursementStatus [reimbStatusId=" + reimbStatusId + ", reimbStatus=" + reimbStatus + "]";
	}

	public ReimbursementStatus(Integer reimbStatusId, String reimbStatus) {
		super();
		this.reimbStatusId = reimbStatusId;
		this.reimbStatus = reimbStatus;
	}
	
	
}
