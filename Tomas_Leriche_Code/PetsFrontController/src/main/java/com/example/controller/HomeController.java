package com.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HomeController {

	public static String Home(HttpServletRequest request) {
		
		
		
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
