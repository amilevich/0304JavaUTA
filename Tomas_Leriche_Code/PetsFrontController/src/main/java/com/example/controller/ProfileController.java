package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.PetDaoImpl;
import com.example.model.Pet;

public class ProfileController {

	public static String Update(HttpServletRequest request) {
		
		Pet pet = (Pet)request.getSession().getAttribute("Pet");
		
		//From html page
		String type = request.getParameter("type");
		String ageString = request.getParameter("age");
		Integer age = Integer.parseInt(ageString);
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		
		PetDaoImpl petDaoImpl = new PetDaoImpl();
		
		pet.setType(type);
		pet.setAge(age);
		pet.setEmail(email);
		pet.setFirst_name(first_name);
		pet.setLast_name(last_name);
	
		petDaoImpl.updatePet(pet);
		
		return "/html/Home.html";
	}
	
}
