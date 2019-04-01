package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.PetDaoImpl;
import com.example.dao.Reimbursement1DaoImpl;
import com.example.model.Pet;
import com.example.model.Reimbursement1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ViewReimbController {
	
	public static String oneReimbJSON(HttpServletRequest request, HttpServletResponse response) {
		
		
		PetDaoImpl petDaoImpl = new PetDaoImpl();
		Reimbursement1DaoImpl reimbursement1DaoImpl = new Reimbursement1DaoImpl();
		
		Pet pet = new Pet();
		// grab the user from the session that logged in.
		pet = (Pet) request.getSession().getAttribute("Pet");
		
		Reimbursement1 reimb = new Reimbursement1();
		
		// grab the reimbursement 
		reimb = reimbursement1DaoImpl.selectReimbById(pet.getUser_id());
		

		request.getSession().setAttribute("Reimb1", reimb);
		
		
		//Pet pet = (Pet)request.getSession().getAttribute("Pet");
		System.out.println(request.getSession().getAttribute("Reimb"));
		//List<Reimbursement1> reimbs = new ArrayList<Reimbursement1>();
		reimb = (Reimbursement1) request.getSession().getAttribute("Reimb1");
		
		
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(reimb));
			/*
			 * Marshalling (similar to serialization) is process of transforming memory representation of an object to a data format
			 * suitable for storage or transmission.
			 * Unmarshalling - > JSON to object
			 * marshalling -> object to JSON
			 * 
			 * Tools: Jackson (JSON marshalling tool)
			 */
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	return null;
		
	}
	
	public static String reimbJSON(HttpServletRequest request, HttpServletResponse response) {
		
	
		PetDaoImpl petDaoImpl = new PetDaoImpl();
		Reimbursement1DaoImpl reimbursement1DaoImpl = new Reimbursement1DaoImpl();
		
		Pet pet = new Pet();
		List<Reimbursement1> reimbs = new ArrayList<Reimbursement1>();
		
		pet = (Pet) request.getSession().getAttribute("Pet");
		
		reimbs = petDaoImpl.selectReimbursementsByUserId(pet.getUser_id());
		

		request.getSession().setAttribute("Reimb", reimbs);
		
		
		//Pet pet = (Pet)request.getSession().getAttribute("Pet");
		System.out.println(request.getSession().getAttribute("Reimb"));
		//List<Reimbursement1> reimbs = new ArrayList<Reimbursement1>();
		reimbs = (List<Reimbursement1>) request.getSession().getAttribute("Reimb");
		
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(reimbs));
			/*
			 * Marshalling (similar to serialization) is process of transforming memory representation of an object to a data format
			 * suitable for storage or transmission.
			 * Unmarshalling - > JSON to object
			 * marshalling -> object to JSON
			 * 
			 * Tools: Jackson (JSON marshalling tool)
			 */
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	return null;
	}
}