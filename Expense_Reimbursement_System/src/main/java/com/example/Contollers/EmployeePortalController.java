package com.example.Contollers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.Model.Reimbursement;
import com.Model.User;
import com.Reimbursement.Dao.ReimbursementDaoImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeePortalController {

	final static Logger Log = Logger.getLogger(EmployeePortalController.class);
	
	public static String SubmitT(HttpServletRequest request, HttpServletResponse response) {
		Log.info("Entered EMPportalController");
		User user = (User)request.getSession().getAttribute("User");
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(user));
			Log.info(user.getUserName()  +  " has logged in");
		}catch(JsonProcessingException e){
			System.out.println("Jackson tool not working");
		}catch(IOException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public static String SubmitR(HttpServletRequest request, HttpServletResponse response) {
		Log.info("Entered ReimbursementController Method");
		
		String amount = request.getParameter("reimbAmount");
		String type = request.getParameter("reimbType");
		String describe = request.getParameter("reimbExplain");
		User user = (User)request.getSession().getAttribute("User");
		
		Reimbursement RI = new Reimbursement(Double.parseDouble(amount),user.getUserName(),describe,0,type);
		ReimbursementDaoImpl RDI = new ReimbursementDaoImpl();
		RDI.insertReimbursement(RI);
		Log.info("Reimbursement Created by " + user.getUserName());
		
		return null;
	}
	

	public static String PopulateTable(HttpServletRequest request, HttpServletResponse response) {
		
//		ReimbursementDaoImpl RDI = new ReimbursementDaoImpl();
//		ArrayList<Reimbursement> RIList =  RDI.selectAllReimbursementsByName(name)
//		request.getSession().setAttribute("RIList",RIList);
//		
		return null;
	}
	

	
}
