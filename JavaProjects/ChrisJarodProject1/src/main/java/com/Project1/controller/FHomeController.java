package com.Project1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Project1.DaoImpl.ReimbursementDaoImpl;
import com.Project1.Model.Reimbursement;
import com.Project1.Model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FHomeController {

	public static String Logout(HttpServletRequest request) {

		return "/html/Login.html";
	}

	public static String Ticket(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("User");
		ReimbursementDaoImpl IReim = new ReimbursementDaoImpl();
		if(request.getParameter("Approval").equals("0")) {
			IReim.deleteReimbursementById(Integer.parseInt(request.getParameter("ReimbursementId")));
		} else {
			IReim.updateReimbursementById(Integer.parseInt(request.getParameter("ReimbursementId")), user);
		}

		return "/html/FHome.html";
	}
	
	
	public static String FilterByResolved(HttpServletRequest request, HttpServletResponse response, int i) {
		//User user = (User) request.getSession().getAttribute("User");
		List<Reimbursement> reim = new ArrayList<Reimbursement>();
		ReimbursementDaoImpl IReim = new ReimbursementDaoImpl();
		reim = IReim.selectReimbursementsByStatusId(i);

		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(reim));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}
	
	public static String ShowAll(HttpServletRequest request, HttpServletResponse response) {
		List<Reimbursement> reim = new ArrayList<Reimbursement>();
		ReimbursementDaoImpl IReim = new ReimbursementDaoImpl();
		reim = IReim.selectAllReimbursements();

		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(reim));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}
}
