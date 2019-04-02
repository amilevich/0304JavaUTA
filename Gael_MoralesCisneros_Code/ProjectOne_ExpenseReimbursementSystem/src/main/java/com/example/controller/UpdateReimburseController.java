package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.example.servlet.MasterServlet;
import com.projectone.dao.ReimbursementDaoImpl;
import com.projectone.models.Reimbursement;
import com.projectone.models.Users;

public class UpdateReimburseController {

	public static String UpdateReimburse(HttpServletRequest request) {
		String srId = request.getParameter("reimbId");
		String approve = request.getParameter("approve");
		String deny = request.getParameter("deny");

		Integer rId = Integer.parseInt(srId);
		Users fManager = (Users)request.getSession().getAttribute("User");

		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		
		Reimbursement r = rdi.selectReimbursementById(rId);
		if(r == null) {
			return "/html/FManagerPortal.html";
		}
		r.setReimbResolved(getTime());
		r.setReimbResolver(fManager.getErsUsersId());
		
		if(deny == null ) {
			r.setReimbStatus("Approved");
//			Main.logger.info("Reimbursement"+rId+" approved");
			rdi.updateReimbursement(r);
		} else {
			r.setReimbStatus("Denied");
//			Main.logger.info("Reimbursement "+rId+" denied");
			rdi.updateReimbursement(r);
		}
		
		return "/html/FManagerPortal.html";
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
