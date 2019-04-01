package com.example.dao;

import java.util.List;

import com.example.model.Reimbursement1;

public interface Reimbursement1Dao {

	//CREATE
	public int insertReimbursement(Reimbursement1 r);
	
	//READ
	public List<Reimbursement1> selectAllReimbursements();
	public Reimbursement1 selectReimbById(int id);
	
	//UPDATE
	public int updateReimbursement(Reimbursement1 r);
	
}
