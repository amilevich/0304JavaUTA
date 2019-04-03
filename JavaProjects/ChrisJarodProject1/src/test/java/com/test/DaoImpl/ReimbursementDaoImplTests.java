package com.test.DaoImpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.Project1.DaoImpl.ReimbursementDaoImpl;
import com.Project1.Model.Reimbursement;

public class ReimbursementDaoImplTests {

	
	@Test
	public void reimbursementInsertSelectRemove() {
		ReimbursementDaoImpl reim = new ReimbursementDaoImpl();
		Reimbursement r = new Reimbursement(99999,100,99999,99999,0,3,"Pls need money");
		reim.insertReimbursement(r);
		Reimbursement r2 = reim.selectReimbursementById(99999);
		reim.deleteReimbursementById(99999);
		boolean test = true;
		if(r.getReimbursementAmount() != r2.getReimbursementAmount())
			test = false;
		if(r.getReimbursementAuthor() != r2.getReimbursementAuthor())
			test = false;
		if(r.getReimbursementResolver() != r2.getReimbursementResolver())
			test = false;
		if(r.getReimbursementStatusId() != r2.getReimbursementStatusId())
			test = false;
		if(r.getReimbursementTypeId() != r2.getReimbursementTypeId())
			test = false;
		if(!(r.getReimbursementDescription().equals(r2.getReimbursementDescription())))
			test = false;
		assertEquals("should return true", true, test);
	}
}
