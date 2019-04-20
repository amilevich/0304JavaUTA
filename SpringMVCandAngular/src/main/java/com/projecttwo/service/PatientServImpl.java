package com.projecttwo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecttwo.model.Patient;
import com.projecttwo.repository.PatientDao;

@Service
public class PatientServImpl {

	@Autowired
	PatientDao pDao;
	
	public List<Patient> getAllPatients(){
		return pDao.selectAll();
	}
	
	public Patient insertPatient(String un, String pw, String fn, String ln, String ssn, String gender, String phone, String email, String street, String city, String state, String zipcode) {
		Patient pat = new Patient(fn,ln,un,pw,ssn,gender,phone,email,street,city,state,zipcode);
		pDao.insert(pat);
		return pat;
	}

	public Patient getPatient(String username, String password) {
		Patient p = new Patient();
		p = pDao.selectByUsernameAndPassword(username, password);
		return p;
	}
}