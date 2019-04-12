package com.projecttwo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttwo.model.Appointment;

@Repository("appointmentrepo")
@Transactional
public class AppointmentDao {
	
	@Autowired
	private SessionFactory sesFact;
	
	public AppointmentDao() {
	}
	
	public void insert(Appointment appointment) {
		sesFact.getCurrentSession().save(appointment);
	}
	
	public Appointment selectById(int id) {
		return sesFact.getCurrentSession().get(Appointment.class, id);
	}
	
	public List<Appointment> selectAll(){
		List<Appointment> applist = sesFact.getCurrentSession().createQuery("from Appointment", Appointment.class).list();
		return applist;
	}
	
	

}
