package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Pet;
import com.example.model.Reimbursement1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HomeController {

	public static String Home(HttpServletRequest request) {
		
		return null;
		
	}
	
	public static String ManJSON(HttpServletRequest request, HttpServletResponse response) {
		List<Reimbursement1> reimbs = (List<Reimbursement1>) request.getSession().getAttribute("Reimbs");
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
	
	public static String PetJSON(HttpServletRequest request, HttpServletResponse response) {
		Pet pet = (Pet)request.getSession().getAttribute("Pet");
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(pet));
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
