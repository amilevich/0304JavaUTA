package com.example.model;

public class Reimbursement1 {

	int reimb_id;
	double reimb_amount;
	int reimb_author;
	String reimb_submitted, reimb_resolved, reimb_description;
	String first_name, last_name;
	int reimb_status_id;
	String reimb_status;

	
	public Reimbursement1() {
		
	}
	
	
	public Reimbursement1(int reimb_id, double reimb_amount, int reimb_author, String reimb_submitted, String reimb_resolved,
							String reimb_description, int reimb_status_id, String reimb_status) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_author = reimb_author;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_status_id = reimb_status_id;
		this.reimb_status = reimb_status;
	}

	public Reimbursement1(int reimb_id, double reimb_amount, int reimb_author, String reimb_submitted, String reimb_resolved,
			String reimb_description, String first_name, String last_name) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_author = reimb_author;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	public Reimbursement1(int reimb_id, double reimb_amount, int reimb_author, String reimb_submitted, String reimb_resolved,
			String reimb_description, String first_name, String last_name, int reimb_status_id) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_author = reimb_author;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.first_name = first_name;
		this.last_name = last_name;
		this.reimb_status_id = reimb_status_id;
	}
	
	
	@Override
	public String toString() {
		return "Reimbursement1 [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_author="
				+ reimb_author + ", reimb_submitted=" + reimb_submitted + ", reimb_resolved=" + reimb_resolved
				+ ", reimb_description=" + reimb_description + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", reimb_status_id=" + reimb_status_id + ", reimb_status=" + reimb_status + "]";
	}


	public int getReimb_status_id() {
		return reimb_status_id;
	}


	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
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


	
	
}
