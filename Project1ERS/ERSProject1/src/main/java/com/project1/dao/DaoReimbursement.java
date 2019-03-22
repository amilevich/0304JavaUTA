package com.project1.dao;

import com.project1.model.Reimbursement;

public interface DaoReimbursement {

	public int insertReimbursement();

	public int updateReimbursemet(Reimbursement r);

	public int selectAllReinbursements(String user);

}
