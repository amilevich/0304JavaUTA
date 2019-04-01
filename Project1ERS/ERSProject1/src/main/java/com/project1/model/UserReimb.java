package com.project1.model;

import java.sql.Blob;
import java.sql.Date;

public class UserReimb {

	private int reimb_Id;
	private Double reimb_amount;
	private Date reimb_submitted;
	private Date reimb_resolved;
	private String reimb_description;
	private Blob reimb_receipt;
	private int reimb_author;
	private int reimb_resolver;
	private int reimb_status_Id;
	private int reimb_type_Id;
	private int ers_user_role_Id;
	private String reimb_resolver_name;
	private String reimb_author_name;
	private String reimbStatus;
	private String reimbType;
	private String ersUsername;
	private String userFirstname;
	private String userLastname;
	
	public UserReimb() {
		
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

	public int getReimb_resolver() {
		return reimb_resolver;
	}

	public void setReimb_resolver(int reimb_resolver) {
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

	public String getErsUsername() {
		return ersUsername;
	}

	public void setErsUsername(String ersUsername) {
		this.ersUsername = ersUsername;
	}

	public String getUserFirstname() {
		return userFirstname;
	}

	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}

	public String getUserLastname() {
		return userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	
	
	public int getErs_user_role_Id() {
		return ers_user_role_Id;
	}

	public void setErs_user_role_Id(int ers_user_role_Id) {
		this.ers_user_role_Id = ers_user_role_Id;
	}

	public String getReimb_resolver_name() {
		return reimb_resolver_name;
	}

	public void setReimb_resolver_name(String reimb_resolver_name) {
		this.reimb_resolver_name = reimb_resolver_name;
	}

	public String getReimb_author_name() {
		return reimb_author_name;
	}

	public void setReimb_author_name(String reimb_author_name) {
		this.reimb_author_name = reimb_author_name;
	}

	@Override
	public String toString() {
		return "UserReimb [reimb_Id=" + reimb_Id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_receipt=" + reimb_receipt + ", reimb_author=" + reimb_author + ", reimb_resolver="
				+ reimb_resolver + ", reimb_status_Id=" + reimb_status_Id + ", reimb_type_Id=" + reimb_type_Id
				+ ", ers_user_role_Id=" + ers_user_role_Id + ", reimb_resolver_name=" + reimb_resolver_name
				+ ", reimb_author_name=" + reimb_author_name + ", reimbStatus=" + reimbStatus + ", reimbType="
				+ reimbType + ", ersUsername=" + ersUsername + ", userFirstname=" + userFirstname + ", userLastname="
				+ userLastname + "]";
	}


	
	}
	
	

