package com.Project1.Dao;

import java.util.List;

import com.Project1.Model.Reimbursement;
import com.Project1.Model.User;

public interface ReimbursementDao {
	
		public int insertReimbursement(Reimbursement r);
		
		public Reimbursement selectReimbursementById(int id);
		public List<Reimbursement> selectReimbursementsByAuthor(String author);
		public List<Reimbursement> selectReimbursementsByStatusId(int statusId);
		public List<Reimbursement> selectAllReimbursements();
		
		public int updateReimbursementById(int id, User user);
		public int deleteReimbursementById(int id);
		
		public int returnMaxReimbursementId();
		public String returnName(int Id);
}
