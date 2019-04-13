package com.projecttwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projecttwo.model.Doctor;
import com.projecttwo.service.DoctorServImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class DoctorCtrl {
	
	@Autowired
	DoctorServImpl docService;
	
	//@CrossOrigin is used to handle the request from a different origin
	@RequestMapping(value="/getdoctors", method=RequestMethod.GET)
	public List<Doctor> getAllDoctors(){
		return docService.getAllDoctors();
	}
	
	@RequestMapping(value="/insertdoctor", method=RequestMethod.GET, params = {"username", "password","firstName","lastName","license"})
	public Doctor insertDoctor(String username,String password, String firstName,String lastName, String license) {
		
		Doctor d = docService.insertDoctor(username, password, firstName, lastName, license);
		return d;
	}
	
	@RequestMapping(value="/getdoctorybyid", method = RequestMethod.GET, params = { "id" })
	public Doctor getDoctorById(String id) {
		Doctor p = docService.getDoctorById(id);
		return p;
	}
	
	@RequestMapping(value="/logindoc", method = RequestMethod.GET, params = { "username", "password"})
	public Doctor getDoctor(String username, String password) {
		Doctor p = docService.getDoctor(username, password);
		return p;
	}

}
