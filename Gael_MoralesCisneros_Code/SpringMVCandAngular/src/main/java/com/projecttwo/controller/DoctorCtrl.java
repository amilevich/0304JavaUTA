package com.projecttwo.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.samples.AmazonSESSample;
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
	
	@RequestMapping(value="/getdoctortest", method=RequestMethod.GET)
	public Doctor getDoctorTest(){
		return docService.getDoctorId(2);
	}
	
	@RequestMapping(value="/getdoctor", method=RequestMethod.GET, params = {"doctorId"})
	public Doctor getDoctorId(int doctorId){
		return docService.getDoctorId(doctorId);
	}

	@RequestMapping(value="/testDoctor", method=RequestMethod.POST)
	public String testDoctor(@RequestBody Doctor doctor) {
		return "it works - " + doctor.getUserName();
	}
	
	@RequestMapping(value="/logindoc", method = RequestMethod.POST)
	public Doctor getDoctor(@RequestBody Doctor doctor) throws ServletException {
		Doctor p = docService.getDoctor(doctor.getUserName(), doctor.getPassWord());
		if (p == null) {
			throw new ServletException("invalid Username or Password.");
		} else {
			return p;
		}
	}
	
	@RequestMapping(value = "/insertDoctor", method = RequestMethod.POST)
	public Doctor insertDoctor(@RequestBody Doctor doctor) {
		Doctor d = docService.insertDoctor(doctor.getUserName(), doctor.getPassWord(), doctor.getFirstName(),
				doctor.getLastName(), doctor.getMedicalId(), doctor.getSsN(), doctor.getPhone(), doctor.getEmail(), doctor.getGender(), doctor.getAffiliation(), doctor.getStreet(), doctor.getCity(), doctor.getState(), doctor.getZipcode(), doctor.getStreet2(), doctor.getCity2(), doctor.getState2(), doctor.getZipcode2(), doctor.getExperience(), doctor.getCertification(), doctor.getEducation(), doctor.getSpecialties(), doctor.getConditions(), doctor.getLanguages(), doctor.getProcedures(), doctor.getInsurances()  );
		AmazonSESSample.sendMail(doctor.getEmail());
		return d;
	}
	
	@RequestMapping(value = "/updateDoctor", method = RequestMethod.POST)
	public Doctor updateDoctorlist(@RequestBody Doctor doctor) {
		//Doctor d = docService.updateDoctor(doctor.getConditions(), doctor.getInsurances(), doctor.getEducation(), doctor.getExperience(), doctor.getLanguages(), doctor.getProcedures(), doctor.getSpecialties());
		return docService.updateDoctor(doctor);
	}
	
}
