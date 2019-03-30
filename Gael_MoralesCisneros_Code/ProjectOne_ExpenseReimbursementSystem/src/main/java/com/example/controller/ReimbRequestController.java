package com.example.controller;

import java.util.Date;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import com.projectone.dao.ReimbursementDaoImpl;
import com.projectone.dao.ReimbursementStatusDaoImpl;
import com.projectone.dao.ReimbursementTypeDaoImpl;
import com.projectone.models.Reimbursement;
import com.projectone.models.ReimbursementStatus;
import com.projectone.models.ReimbursementType;
import com.projectone.models.Users;

public class ReimbRequestController {

	public static String ReimbRequest(HttpServletRequest request) {
		
		String expenseType = request.getParameter("expenseType");
		String amount = request.getParameter("amount");
		String comments = request.getParameter("comments");
		
		ReimbursementTypeDaoImpl rtdi = new ReimbursementTypeDaoImpl();
		ReimbursementStatusDaoImpl rsdi = new ReimbursementStatusDaoImpl();
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		
		ReimbursementType rt = new ReimbursementType();
		rt.setReimbType(expenseType);
		rtdi.insertReimbursementType(rt);
		
		ReimbursementStatus rs = new ReimbursementStatus();
		rs.setReimbStatus("Pending");
		rsdi.insertReimbursementStatus(rs);
		
		Reimbursement r = new Reimbursement();
		Integer statusId = rdi.selectReimbursementStatusByMax();
		Integer typeId = rdi.selectReimbursementTypeByMax();
		Users user = (Users)request.getSession().getAttribute("User");
		Integer userId = rdi.selectUserIDByUsername(user.getErsUsername());
		
		//debug--------------------------------------
		System.out.println("amount: "+amount);
		System.out.println("userId: "+userId);
		System.out.println("timestamp: "+getTime());
		System.out.println("comments: "+comments);
		System.out.println("statusId: "+statusId);
		System.out.println("typeId: "+typeId);
		//-------------------------------------------
		
		r.setReimbAmount(Double.parseDouble(amount));
		r.setReimbAuthor(userId);
		r.setReimbSubmitted(getTime());
		r.setReimbDescription(comments);
		r.setReimbStatusId(statusId);
		r.setReimbTypeId(typeId);
		r.setReimbResolver(2);
		rdi.insertReimbursement(r);
		
		//debug--------------------------------------
		System.out.println("reimbursement: "+r);
		//-------------------------------------------
		
		return "/html/EmployeePortal.html";
		
	}
	
	public static Timestamp getTime() {
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        return ts;
    }
}
