package com.Reimbursement.Dao;

import java.util.List;

import com.Model.Reimbursement;

public interface ReimbursementDao {

	//CRUD methods
		//CREATE
		public int insertReimbursement(Reimbursement r);
		
		//READ
		public Reimbursement selectReimbursementByName(String name);
		public List<Reimbursement> selectAllReimbursements();
		
		// UPDATE
		public int updateReimbursement(Reimbursement r);
		
		// DELETE
		public int deleteReimbursement(Integer r);

		int nextSequence();

		Reimbursement selectReimbursementById(int id);
}
