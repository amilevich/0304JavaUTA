package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.PetDaoImpl;
import com.example.dao.Reimbursement1DaoImpl;
import com.example.model.Pet;
import com.example.model.Reimbursement1;

public class ReimbProfileController {

public static String Update(HttpServletRequest request) {
		
		//Pet pet = (Pet)request.getSession().getAttribute("Pet");
		List<Reimbursement1> reimbs = (List<Reimbursement1>) request.getSession().getAttribute("Reimb");
		
		System.out.println(reimbs);
		//From html page
		String pre_reimb_id = request.getParameter("reimb_id");
		String reimb_amount = request.getParameter("reimb_amount");
		Double reimb_amountNum = Double.parseDouble(reimb_amount);
		Integer reimb_id = Integer.parseInt(pre_reimb_id);
		int reimb_id_int = reimb_id;
		
		
		String reimb_description = request.getParameter("reimb_description");

		Reimbursement1 reimb = null;
		
		// how to get this number?
		for (int x = 0; x < reimbs.size(); x++) {
			if (reimbs.get(x).getReimb_id() == reimb_id_int) {
//				System.out.println(reimbs.get(x).getReimb_id());
//				System.out.println(reimb_id_int);
				reimb = reimbs.get(x);
				//System.out.println("THIS 2" + reimb);
				break;
			}
			else {
				reimb = null;
			}
			
		}
		
		System.out.println(" THis one:  " + reimb);
		
		PetDaoImpl petDaoImpl = new PetDaoImpl();
		Reimbursement1DaoImpl reimbDaoImpl = new Reimbursement1DaoImpl();
		if (reimb != null) {
			System.out.println(" THis one:  " + reimb);
			reimb.setReimb_amount(reimb_amountNum);
			reimb.setReimb_description(reimb_description);
	
			reimbDaoImpl.updateReimbursement(reimb);
			//petDaoImpl.updatePet(pet);
		}
		return "/html/Reimbursements.html";
	}
}
