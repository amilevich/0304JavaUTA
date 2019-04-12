package com.projecttwo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projecttwo.model.Doctor;
import com.projecttwo.repository.DoctorDao;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {

	@Autowired
	private DoctorDao dDao;

	public DoctorController() {
	}

	
	@PostMapping(value = "/api/login.app")
	public @ResponseBody Doctor getDoctorByUsername(@RequestParam Map<String, String> allParams) {
		String un = allParams.get("userName");
		String pw = allParams.get("passWord");

		Doctor d = dDao.selectByUsernameAndPassword(un, pw);
		return d;
	}

	@PostMapping(value = "/register.app")
	public @ResponseBody void insertDoctor(@RequestParam Map<String, String> allParams) {
		Doctor d = null;
		d.setFirstName(allParams.get("firstName"));
		d.setLastName(allParams.get("lastName"));
		d.setUserName(allParams.get("userName"));
		d.setPassWord(allParams.get("passWord"));
		
		int ssn = Integer.parseInt(allParams.get("ssN"));
		int phone = Integer.parseInt(allParams.get("phone"));
		String email = allParams.get("email");
		String mid = allParams.get("medicalId");
		String ins = allParams.get("insurance");
		String street = allParams.get("street");
		String city = allParams.get("city");
		String state = allParams.get("state");
		int zip = Integer.parseInt(allParams.get("zipcode"));
		

	}

}
