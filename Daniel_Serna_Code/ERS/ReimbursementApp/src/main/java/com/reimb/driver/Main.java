package com.reimb.driver;

import org.apache.log4j.Logger;

import com.reimb.dao.ReimbursementDaoImpl;
import com.reimb.model.Reimbursement;

public class Main {

	
	final static Logger logger = Logger.getLogger(Main.class);
	
	
	public static void main(String[] args) {
		logger.info("Main.java started running.\n");
		
		System.out.println("hi");
		
		Reimbursement re = new Reimbursement(500.25, "24-MAR-19 08.01.26 PM", "24-MAR-19 08.01.26 PM", "Description: This is a test", null, 99, 99, 99, 99);
	
		ReimbursementDaoImpl reimbursementDaoImpl = new ReimbursementDaoImpl();
		reimbursementDaoImpl.insertReimbursement(re);
		
		System.out.println(reimbursementDaoImpl.selectAllReimbursement());
	}
}
