package com.projecttwo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projecttwo.model.Patient;
import com.projecttwo.repository.PatientDao;

public class PatientController {

	@Autowired
	private PatientDao pdao;

	public PatientController() {
	}
	// @CrossOrigin(origins="http://localhost:4200")
	// @PostMapping(value="/login.app")
	// public @ResponseBody Patient
	// getPatientByUsername(@RequestParam("username")String un) {
	// return pdao.selectByUsername(un);

	// }

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/register.app")
	public @ResponseBody void insertPatient(@RequestParam Map<String, String> allParams) {
		String fn = allParams.get("firstName");
		String ln = allParams.get("lastName");
		String un = allParams.get("userName");
		String pw = allParams.get("passWord");
		int ssn = Integer.parseInt(allParams.get("ssN"));
		String gen = allParams.get("gender");

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/login.app")
	public @ResponseBody Patient login(@RequestParam Map<String, String> allParams) {
		String un = allParams.get("username");
		String pw = allParams.get("password");
		
//		Patient p = pdao.auth(un, pw);
		return null;
	}
}
