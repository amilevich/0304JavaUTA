package com.projecttwo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecttwo.model.Condition;
import com.projecttwo.model.Doctor;
import com.projecttwo.model.Insurance;
import com.projecttwo.model.Language;
import com.projecttwo.model.Procedure;
import com.projecttwo.model.Specialty;
import com.projecttwo.repository.DoctorDao;

@Service
public class DoctorServImpl {

	@Autowired
	DoctorDao ddao;

	public List<Doctor> getAllDoctors() {
		return ddao.selectAll();
	}

	public Doctor getDoctorId(int doctorId) {
		return ddao.selectById(doctorId);
	}


	 public Doctor insertDoctor(String un, String pw, String fn, String ln, String
	 ls, String i, String phone, String string, String string2, String string3, String
	 string4, String string5, String string6, String k, String string7, String
	 string8, String string9, String l, int m, String string10, String string11,
	 List<Specialty> list, List<Condition> list2, List<Language> list3,
	 List<Procedure> list4, List<Insurance> list5) {
	 Doctor doc = new Doctor(fn,ln,un,pw,i, phone,
	 string,ls,string2,string3,string4,string5,string6,k,string7,string8,string9,l,m,string10,string11,list,list2,list3,list4,list5,
	 null, string11);
	 ddao.insert(doc);
	 return doc;
	 }

	public Doctor getDoctor(String un, String pw) {
		Doctor d = new Doctor();
		d = ddao.selectByUsernameAndPassword(un, pw);
		return d;

	}

	public Doctor insertDoctor(String un, String pw, String fn, String ln, String ls, String str, String ct, String sta,
			String zip) {

		Doctor doc = new Doctor(fn, ln, un, pw, ls, str, ct, sta, zip);
		ddao.insert(doc);
		Doctor b = new Doctor();
		b = ddao.selectByUsernameAndPassword(un, pw);
		return b;
	}
	
	 public Doctor insertDoctor(Doctor doctor) {
		 return ddao.insert(doctor);
	 }
	
	 public Doctor updateDoctor(Doctor doctor) {
		 return ddao.update(doctor);
	 }
	
}
