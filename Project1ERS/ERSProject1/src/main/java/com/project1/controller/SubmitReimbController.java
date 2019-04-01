package com.project1.controller;



import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import com.project1.model.Reimbursement;
import com.project1.dao.DaoReimbursementImpl;

public class SubmitReimbController {

	public static String SubmitReimb(HttpServletRequest request) {

		String amount = request.getParameter("amount");
		String description = request.getParameter("description");
		String type = request.getParameter("reimbType");
		
		int reimbType;
		switch (type) {
		case "LODGING":
			reimbType=1;
			break;
		case "TRAVEL":
			reimbType=2;
			break;
		case "FOOD":
			reimbType=3;
			break;
		default:
			reimbType=4;
			break;
		}

		DaoReimbursementImpl daoReimbursementImpl = new DaoReimbursementImpl();
		Reimbursement reimbursement = new Reimbursement();

		Double reimbAmt = Double.parseDouble(amount);
		Date today = new Date(System.currentTimeMillis());
		
		reimbursement.setReimb_amount(reimbAmt);
		reimbursement.setReimb_submitted(today);
		reimbursement.setReimb_resolved(null);
		reimbursement.setReimb_description(description);
		reimbursement.setReimb_receipt(null);
		reimbursement.setReimb_author(6);
		reimbursement.setReimb_resolver(null);
		reimbursement.setReimb_status_Id(2);
		reimbursement.setReimb_type_Id(reimbType);
				
		int reimbursementId = daoReimbursementImpl.insertReimbursement(reimbursement);

		request.getSession().setAttribute("Reimbursement", reimbursement);
		return "ViewReimb.html";

	}
}