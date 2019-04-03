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
		
		System.out.println("THIIIISSS" + reimb);
		// crash if newly made
		//System.out.println(reimb.get(0).getReimb_amount());
		// get reimbursements by user id
		List<Reimbursement1> reimbs = reimbursement1DaoImpl.selectAllPetsReimbs();
		System.out.println(reimbs);
		
		// TODO: ADD CONDITION FOR MANAGER LOGIN
		if (name.equals(pet.getName()) && type.equals(pet.getType()) && pet.getRole_id() == 1) {
			
			request.getSession().setAttribute("Pet", pet);
			request.getSession().setAttribute("Reimb", reimb);

			
			return "/html/Home.html";
		}else if (name.equals(pet.getName()) && type.equals(pet.getType()) && pet.getRole_id() == 0) {
			
			System.out.println("admin loging in");
			request.getSession().setAttribute("Pet", pet);
			request.getSession().setAttribute("Reimb", reimb);
			request.getSession().setAttribute("Reimbs", reimbs);
			
			
			return "/html/Home2.html";
		}
		
		return "/html/Login.html";
	}
	
}
