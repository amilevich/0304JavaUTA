package com.projecttwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projecttwo.model.Patient;
import com.projecttwo.service.PatientServImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class PatientCtrl {

	@Autowired
	PatientServImpl patService;
	
	@RequestMapping(value="/getpatients", method=RequestMethod.GET)
	public List<Patient> getAllPatients(){
		return patService.getAllPatients();
	}
	
	@RequestMapping(value="/insertpatient", method=RequestMethod.GET, params = {"username", "password","firstName","lastName"})
	public Patient insertPatient(String username,String password, String firstName,String lastName) {
		
		Patient p = patService.insertPatient(username, password, firstName, lastName);
		return p;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET, params = { "username", "password"})
	public Patient getPatient(String username, String password) {
		Patient p = patService.getPatient(username, password);
		return p;
	}
}
