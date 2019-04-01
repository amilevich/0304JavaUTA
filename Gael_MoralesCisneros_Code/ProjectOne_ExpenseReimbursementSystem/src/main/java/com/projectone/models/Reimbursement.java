package com.projectone.models;

public class Reimbursement {
    private Integer reimbId;
    private Double reimbAmount;
    private String reimbSubmitted;
    private String reimbResolved;
    private String reimbDescription;
    private Integer reimbAuthor;
    private Integer reimbResolver;
    private String reimbStatus;
    private String reimbType;
    
    public Reimbursement() {
    }
    
    

    public Reimbursement(Double reimbAmount, String reimbSubmitted) {
        super();
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
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



	public String getReimbStatus() {
		return reimbStatus;
	}



	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}



	public String getReimbType() {
		return reimbType;
	}



	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}



	public Reimbursement(Integer reimbId, Double reimbAmount, String reimbSubmitted, String reimbResolved,
			String reimbDescription, Integer reimbAuthor, Integer reimbResolver, String reimbStatus, String reimbType) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}



	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver + ", reimbStatus=" + reimbStatus
				+ ", reimbType=" + reimbType + "]";
	}


    
    
}