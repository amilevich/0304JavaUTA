package com.projecttwo.controller;

import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.samples.AmazonSESSample;
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
	
	
	@RequestMapping(value = "/insertPatient", method = RequestMethod.POST)
	public Patient insertPatient(@RequestBody Patient patient) {
		
		Patient p = patService.insertPatient(patient.getUserName(), patient.getPassWord(), patient.getFirstName(),patient.getLastName(),  patient.getSsN(),patient.getGender(),patient.getPhone(), patient.getEmail(), patient.getStreet(), patient.getCity(), patient.getState(), patient.getZipcode());
		AmazonSESSample.sendMail(patient.getEmail());
		return p;
	}
	
	@RequestMapping(value="/loginpat", method = RequestMethod.POST)
	public Patient getPatient(@RequestBody Patient patient) throws ServletException {
		Patient p = patService.getPatient(patient.getUserName(), patient.getPassWord());
		if (p == null) {
			throw new ServletException("invalid Username or Password.");
		} else {
			return p;
		}
	}
	
//	@RequestMapping(value="/login", method = RequestMethod.GET, params = { "username", "password"})
//	public Patient getPatient(String username, String password) {
//		Patient p = patService.getPatient(username, password);
//		return p;
//	}
}