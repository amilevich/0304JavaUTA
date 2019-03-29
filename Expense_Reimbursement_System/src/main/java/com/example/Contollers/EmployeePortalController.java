package com.example.Contollers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class EmployeePortalController {

	final static Logger Log = Logger.getLogger(EmployeePortalController.class);
	public static String SubmitT(HttpServletRequest request, HttpServletResponse response) {
		Log.info("Entered EMPportalController");
		int amount = request.getParameter("reimbAmount");
		
		return null;
	}
	
}
