package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectone.dao.ReimbursementDaoImpl;
import com.projectone.models.Reimbursement;
import com.projectone.models.Users;

public class JSONController {

	public static String PopulateTable(HttpServletRequest request, HttpServletResponse response) {
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		List<Reimbursement> rL = new ArrayList<Reimbursement>();
		rL = rdi.selectAllReimbursements();
		
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(rL));
		
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String PopulateEmpTable(HttpServletRequest request, HttpServletResponse response) {
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		List<Reimbursement> rL = new ArrayList<Reimbursement>();
		rL = rdi.selectAllReimbursements();
		Users emp = (Users)request.getSession().getAttribute("User");
		Integer empId = emp.getErsUsersId();
		List<Reimbursement>nrL = new ArrayList<Reimbursement>();
		for(Reimbursement r: rL) {
			if(r.getReimbAuthor().equals(empId)) {
				System.out.println(r);
				nrL.add(r);
			}
		}
		
		System.out.println(nrL);
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(nrL));
		
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
}
