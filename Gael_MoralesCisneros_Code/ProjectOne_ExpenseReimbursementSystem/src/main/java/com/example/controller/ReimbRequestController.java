package com.example.controller;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import com.example.servlet.MasterServlet;
import com.projectone.dao.ReimbursementDaoImpl;
import com.projectone.models.Reimbursement;
import com.projectone.models.Users;

public class ReimbRequestController {

	public static String ReimbRequest(HttpServletRequest request) {
		
		String expenseType = request.getParameter("expenseType");
		String amount = request.getParameter("amount");
		String comments = request.getParameter("comments");
		
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		Reimbursement r = new Reimbursement();
	
		Users user = (Users)request.getSession().getAttribute("User");
		Integer userId = rdi.selectUserIDByUsername(user.getErsUsername());
		
		//debug--------------------------------------
		System.out.println("amount: "+amount);
		System.out.println("userId: "+userId);
		System.out.println("timestamp: "+getTime());
		System.out.println("comments: "+comments);
		System.out.println("statusId: "+"Pending");
		System.out.println("typeId: "+expenseType);
		//-------------------------------------------
		
		r.setReimbAmount(Double.parseDouble(amount));
		r.setReimbAuthor(userId);
		r.setReimbSubmitted(getTime());
		r.setReimbDescription(comments);
		r.setReimbType(expenseType);
		r.setReimbStatus("Pending");
		rdi.insertReimbursement(r);
		
//		Main.logger.info("New reimbursement request: "+r);	
		return "/html/EmployeePortal.html";
		
	}
	
	public static String getTime() {
        Date date = new Date();
        //long time = date.getTime();
        //Timestamp ts = new Timestamp(time);
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        //return ts;
        return timeStamp;
    }
}
