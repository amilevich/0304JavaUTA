package com.projectone.dao;

import java.sql.Timestamp;

import com.projectone.models.Reimbursement;

public interface ReimbursementDao {

	//CREATE
	public int insertReimbursement(Reimbursement p);

	//READ
	public Reimbursement selectReimbursementById(Integer x);

	//UPDATE
	public int updateReimbursement(Timestamp x, Integer y);
	//DELETE
}
