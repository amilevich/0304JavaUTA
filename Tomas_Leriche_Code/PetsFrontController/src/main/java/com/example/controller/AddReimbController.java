package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.PetDaoImpl;
import com.example.dao.Reimbursement1DaoImpl;
import com.example.model.Reimbursement1;

public class AddReimbController {

	public static String AddReimb(HttpServletRequest request) {
		
		String amount = request.getParameter("reimb_amount");
		String author = request.getParameter("reimb_author");
		String description = request.getParameter("reimb_description");
		
		Double amountNum = Double.parseDouble(amount);
		Integer authorNum = Integer.parseInt(author);
		
		Reimbursement1 reimb = new Reimbursement1();
		
		reimb.setReimb_amount(amountNum);
		reimb.setReimb_author(authorNum);
		reimb.setReimb_description(description);
		
		Reimbursement1DaoImpl reimbursement1DaoImpl = new Reimbursement1DaoImpl();
		
		reimbursement1DaoImpl.insertReimbursement(reimb);
		
		return "/html/Reimbursements.html";
		
	}
	
}