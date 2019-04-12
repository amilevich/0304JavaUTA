package com.projecttwo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecttwo.model.Doctor;
import com.projecttwo.model.Employee;
import com.projecttwo.repository.DoctorDao;

@Service
public class DoctorServImpl {
	
	@Autowired
	DoctorDao ddao;
	
	public List<Doctor> getAllDoctors(){
		return ddao.selectAll();
	}
	
	public Doctor insertDoctor(String un, String pw, String fn, String ln, String ls) {
		Doctor doc = new Doctor(fn,ln,un,pw,ls);
		ddao.insert(doc);
		Doctor b = new Doctor();
			b=	ddao.selectByUsernameAndPassword(un,pw);
		return b;
	}

}
