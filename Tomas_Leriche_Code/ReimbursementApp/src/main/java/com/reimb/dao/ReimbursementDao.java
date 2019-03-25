package com.reimb.dao;

import java.util.List;

import com.reimb.model.Reimbursement;

public interface ReimbursementDao {

	// CREATE
	public int insertReimbursement(Reimbursement r); // insert reimbursement object into DB

	// READ
	public Reimbursement searchReimbursementById(Integer id); // grab a specific reimbursement record

	public List<Reimbursement> selectAllReimbursement(); // select all reimbursement objects

	// UPDATE
	public int updateReimbursement(Reimbursement r); // update reimbursement record

	// DELETE
	public void deleteReimbursement(Integer id); // delete reimbursement record by id

}