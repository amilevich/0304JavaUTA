package com.projectone.dao;

import java.sql.Timestamp;
import java.util.List;

import com.projectone.models.Reimbursement;

public interface ReimbursementDao {

	//CREATE
	public int insertReimbursement(Reimbursement p);

	//READ
	public Reimbursement selectReimbursementById(Integer x);
	public Integer selectReimbursementStatusByMax();
	public Integer selectReimbursementTypeByMax();
	public Integer selectUserIDByUsername(String x);
	public List<Reimbursement> selectAllReimbursements();

	//UPDATE
	public int updateReimbursement(Timestamp x, Integer y);
	//DELETE
}
