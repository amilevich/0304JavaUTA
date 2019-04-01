package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.PetDaoImpl;
import com.example.dao.Reimbursement1DaoImpl;
import com.example.model.Pet;
import com.example.model.Reimbursement1;

public class LoginController {

	public static String Login(HttpServletRequest request) {
		
		
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		
		PetDaoImpl petDaoImpl = new PetDaoImpl();
		Reimbursement1DaoImpl reimbursement1DaoImpl = new Reimbursement1DaoImpl();
		
		Pet pet = new Pet();
		List<Reimbursement1> reimb = new ArrayList<Reimbursement1>();
		
		pet = petDaoImpl.selectPetByName(name);
		reimb = petDaoImpl.selectReimbursementsByUserId(pet.getUser_id());
		
		// crash if newly made
		//System.out.println(reimb.get(0).getReimb_amount());
		// get reimbursements by user id
		
		
		// TODO: ADD CONDITION FOR MANAGER LOGIN
		if (name.equals(pet.getName()) && type.equals(pet.getType())) {
			
			request.getSession().setAttribute("Pet", pet);
			request.getSession().setAttribute("Reimb", reimb);

			
			return "/html/Home.html";
		}
		
		return "/html/Login.html";
	}
	
}
