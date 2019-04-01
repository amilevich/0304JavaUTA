package com.example.model;

public class Reimbursement1 {

	int reimb_id;
	double reimb_amount;
	int reimb_author;
	String reimb_submitted, reimb_resolved, reimb_description;

	
	public Reimbursement1() {
		
	}
	
	
	public Reimbursement1(int reimb_id, double reimb_amount, int reimb_author, String reimb_submitted, String reimb_resolved,
							String reimb_description) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_author = reimb_author;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
	}

	
	
	public String getReimb_description() {
		return reimb_description;
	}


	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}


	public String getReimb_resolved() {
		return reimb_resolved;
	}


	public void setReimb_resolved(String reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}


	public String getReimb_submitted() {
		return reimb_submitted;
	}


	public void setReimb_submitted(String reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}


	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public double getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public int getReimb_author() {
		return reimb_author;
	}

	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}

	@Override
	public String toString() {
		return "Reimbursement1 [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_author="
				+ reimb_author + "]";
	}
	
	
	
}
