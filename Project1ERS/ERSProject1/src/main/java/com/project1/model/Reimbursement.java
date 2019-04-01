package com.project1.model;

import java.sql.Blob;
import java.sql.Date;

public class Reimbursement {

	private int reimb_Id;
	private Double reimb_amount;
	private Date reimb_submitted;
	private Date reimb_resolved;
	private String reimb_description;
	private Blob reimb_receipt;
	private int reimb_author;
	private Integer reimb_resolver;
	private int reimb_status_Id;
	private int reimb_type_Id;

	public Reimbursement() {

	}

	public Reimbursement(Double reimb_amount, Date reimb_submitted, Date reimb_resolved, String reimb_description,
			Blob reimb_receipt, int reimb_author, Integer reimb_resolver, int reimb_status_Id, int reimb_type_Id) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_Id = reimb_status_Id;
		this.reimb_type_Id = reimb_type_Id;
	}

	public Reimbursement(int reimb_Id, Double reimb_amount, Date reimb_submitted, Date reimb_resolved, String reimb_description,
			Blob reimb_receipt, int reimb_author, Integer reimb_resolver, int reimb_status_Id, int reimb_type_Id) {
		super();
		this.reimb_Id = reimb_Id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_Id = reimb_status_Id;
		this.reimb_type_Id = reimb_type_Id;
	}

	public int getReimb_Id() {
		return reimb_Id;
	}

	public void setReimb_Id(int reimb_Id) {
		this.reimb_Id = reimb_Id;
	}

	public Double getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(Double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public Date getReimb_submitted() {
		return reimb_submitted;
	}

	public void setReimb_submitted(Date reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}

	public Date getReimb_resolved() {
		return reimb_resolved;
	}

	public void setReimb_resolved(Date reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public Blob getReimb_receipt() {
		return reimb_receipt;
	}

	public void setReimb_receipt(Blob reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}

	public int getReimb_author() {
		return reimb_author;
	}

	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}

	public Integer getReimb_resolver() {
		return reimb_resolver;
	}

	public void setReimb_resolver(Integer reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}

	public int getReimb_status_Id() {
		return reimb_status_Id;
	}

	public void setReimb_status_Id(int reimb_status_Id) {
		this.reimb_status_Id = reimb_status_Id;
	}

	public int getReimb_type_Id() {
		return reimb_type_Id;
	}

	public void setReimb_type_Id(int reimb_type_Id) {
		this.reimb_type_Id = reimb_type_Id;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimb_Id=" + reimb_Id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_receipt=" + reimb_receipt + ", reimb_author=" + reimb_author + ", reimb_resolver=" + reimb_resolver
				+ ", reimb_status_Id=" + reimb_status_Id + ", reimb_type_Id=" + reimb_type_Id + "]";
	}

}
