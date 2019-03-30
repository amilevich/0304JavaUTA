package com.projectone.dao;

import com.projectone.models.ReimbursementStatus;
import com.projectone.models.ReimbursementType;

public interface ReimbursementStatusDao {

	//CREATE
	public int insertReimbursementStatus(ReimbursementStatus x);
	//READ
	public ReimbursementStatus selectReimbursementStatusByName(Integer x);
	//UPDATE
	public int updateReimbursementStatus(String x, Integer y);
	//DELETE
}
