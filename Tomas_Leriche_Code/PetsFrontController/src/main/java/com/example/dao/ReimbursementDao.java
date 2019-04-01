package com.example.dao;

import java.util.List;

import com.example.model.Reimbursement;

public interface ReimbursementDao {

	
	// CREATE
	public int insertReimbursement(Reimbursement r);
	
	// READ
	public List<Reimbursement> selectAllReimbursements();
	
	// UPDATE
	public int updateReimbursement(Reimbursement r);
	
	
	
}
