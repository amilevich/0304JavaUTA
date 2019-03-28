package com.projectone.models;

public class ReimbursementType {

	private Integer reimbTypeId;
	private String reimbType;
	
	public ReimbursementType() {
	}

	public ReimbursementType(String reimbType) {
		super();
		this.reimbType = reimbType;
	}

	public Integer getReimbTypeId() {
		return reimbTypeId;
	}

	public void setReimbTypeId(Integer reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}

	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public String toString() {
		return "ReimbursementType [reimbTypeId=" + reimbTypeId + ", reimbType=" + reimbType + "]";
	}

	public ReimbursementType(Integer reimbTypeId, String reimbType) {
		super();
		this.reimbTypeId = reimbTypeId;
		this.reimbType = reimbType;
	}
	
	
}
