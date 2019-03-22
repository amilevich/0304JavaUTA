package com.project1.model;

public class Type {

	private int reimbTypeId;
	private String reimbType;

	public Type() {

	}

	public Type(String reimbType) {
		super();
		this.reimbType = reimbType;
	}

	public Type(int reimbTypeId, String reimbType) {
		super();
		this.reimbTypeId = reimbTypeId;
		this.reimbType = reimbType;
	}

	public int getReimbTypeId() {
		return reimbTypeId;
	}

	public void setReimbTypeId(int reimbTypeId) {
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
		return "Type [reimbTypeId=" + reimbTypeId + ", reimbType=" + reimbType + "]";
	}

}
