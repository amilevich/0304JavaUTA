package com.example.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.projectone.dao.ReimbursementDaoImpl;
import com.projectone.dao.ReimbursementStatusDaoImpl;
import com.projectone.models.Reimbursement;
import com.projectone.models.ReimbursementStatus;

public class UpdateReimburseController {

	public static String UpdateReimburse(HttpServletRequest request) {
		String status = request.getParameter("status");
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		ReimbursementStatusDaoImpl rsdi = new  ReimbursementStatusDaoImpl();
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		
		Reimbursement r = rdi.selectReimbursementById(id);
		r.setReimbResolved(getTime());
		Integer statusId = r.getReimbStatusId();
		
		rsdi.updateReimbursementStatus("Approved", statusId);
		
//		Reimbursement r = rdi.selectReimbursementById(id);
//		r.setReimbResolved(getTime());
//		Integer statusId = r.getReimbStatusId();
//		
//		rsdi.updateReimbursementStatus("Denied", statusId);
		
		
		
		return "html/FManagerPortal.html";
	}
	
	public static Timestamp getTime() {
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        return ts;
    }
}
