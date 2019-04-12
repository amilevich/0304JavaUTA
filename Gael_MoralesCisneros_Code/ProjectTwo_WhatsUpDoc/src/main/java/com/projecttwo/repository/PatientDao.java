package com.projecttwo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttwo.model.Patient;

@Repository("patientRepo")
@Transactional
public class PatientDao {
	
	@Autowired
	private SessionFactory sesFact;
	
	public PatientDao() {
	}
	
	public void insert(Patient patient) {
		sesFact.getCurrentSession().save(patient);
	}
	
	public Patient selectById(int id) {
		return sesFact.getCurrentSession().get(Patient.class, id);
	}
	
	public List<Patient> selectAll(){
		List<Patient> patientlist = sesFact.getCurrentSession().createQuery("from Patient", Patient.class).list();
		return patientlist;
	}
	

}
