package com.projectone.dao;

import com.projectone.models.ReimbursementType;

public interface ReimbursementTypeDao {

	//CREATE
	public int insertReimbursementType(ReimbursementType x);
	//READ
	public ReimbursementType selectReimbursementTypeByName(Integer x);

	//UPDATE
	//DELETE
}
