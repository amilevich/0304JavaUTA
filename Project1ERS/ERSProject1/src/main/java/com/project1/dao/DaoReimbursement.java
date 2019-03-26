package com.project1.dao;

import java.util.List;

import com.project1.model.Reimbursement;
import com.project1.model.UserReimb;

public interface DaoReimbursement {

	public int insertReimbursement(Reimbursement reimbursement);

	public int updateReimbursement(Reimbursement reimbursement);

	public List<UserReimb> selectAllReimbursements(int user_Id);
	
	public List<UserReimb> selectReimbursementsByUser(int user_Id);

}
