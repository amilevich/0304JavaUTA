package com.projecttwo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttwo.model.Doctor;

@Repository("doctorRepo")
@Transactional
public class DoctorDao {
	
	@Autowired
	private SessionFactory sesFact;
	
	public DoctorDao() {
	}
	
	public void insert(Doctor doctor) {
		sesFact.getCurrentSession().save(doctor);
	}
	
	public Doctor selectById(int id) {
		return sesFact.getCurrentSession().get(Doctor.class, id);
	}
	
	public List<Doctor> selectAll(){
		List<Doctor> doclist = sesFact.getCurrentSession().createQuery("from Doctor", Doctor.class).list();
		return doclist;
	}
	

	public Doctor selectByUsernameAndPassword(String un, String pw) {
		List<Doctor> dList = sesFact.getCurrentSession().createQuery("from Doctor where username="+un+" and password="+pw,Doctor.class).list();
		return dList.get(0);
	}
}
