package com.Project1.Model;

public class Reimbursement {
	private int reimbursementId, reimbursementAmount, reimbursementAuthor, reimbursementResolver;
	private int reimbursementStatusId, reimbursementTypeId;
	private String reimbursementDescription, author, resolver;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int reimbursementId, int reimbursementAmount, int reimbursementAuthor,
			int reimbursementResolver, int reimbursementStatusId, int reimbursementTypeId,
			String reimbursementDescription) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementAuthor = reimbursementAuthor;
		this.reimbursementResolver = reimbursementResolver;
		this.reimbursementStatusId = reimbursementStatusId;
		this.reimbursementTypeId = reimbursementTypeId;
		this.reimbursementDescription = reimbursementDescription;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", reimbursementAmount=" + reimbursementAmount
				+ ", reimbursementAuthor=" + reimbursementAuthor + ", reimbursementResolver=" + reimbursementResolver
				+ ", reimbursementStatusId=" + reimbursementStatusId + ", reimbursementTypeId=" + reimbursementTypeId
				+ ", reimbursementDescription=" + reimbursementDescription + "]";
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getReimbursementAmount() {
		return reimbursementAmount;
	}

	public void setReimbursementAmount(int reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}

	public int getReimbursementAuthor() {
		return reimbursementAuthor;
	}

	public void setReimbursementAuthor(int reimbursementAuthor) {
		this.reimbursementAuthor = reimbursementAuthor;
	}

	public int getReimbursementResolver() {
		return reimbursementResolver;
	}

	public void setReimbursementResolver(int reimbursementResolver) {
		this.reimbursementResolver = reimbursementResolver;
	}

	public int getReimbursementStatusId() {
		return reimbursementStatusId;
	}

	public void setReimbursementStatusId(int reimbursementStatusId) {
		this.reimbursementStatusId = reimbursementStatusId;
	}

	public int getReimbursementTypeId() {
		return reimbursementTypeId;
	}

	public void setReimbursementTypeId(int reimbursementTypeId) {
		this.reimbursementTypeId = reimbursementTypeId;
	}

	public String getReimbursementDescription() {
		return reimbursementDescription;
	}

	public void setReimbursementDescription(String reimbursementDescription) {
		this.reimbursementDescription = reimbursementDescription;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}
	
}
