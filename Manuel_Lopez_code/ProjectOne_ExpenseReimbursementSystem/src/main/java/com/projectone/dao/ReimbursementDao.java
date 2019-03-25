package com.projectone.dao;

import com.projectone.models.Reimbursement;

public interface ReimbursementDao {

	//CREATE
	public int insertReimbursement(Reimbursement p);

	//READ
	public Reimbursement selectReimbursementById(Integer x);

	//UPDATE
	//DELETE
}
