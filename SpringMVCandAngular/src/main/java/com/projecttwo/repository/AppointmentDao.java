package com.projecttwo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttwo.model.Appointment;
import com.projecttwo.model.Doctor;
import com.projecttwo.util.HibernateUtil;

@Repository
public class AppointmentDao {
	
	public void insert(Appointment a) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(a);
		tx.commit();
		
	}
	
	public void update(Appointment a) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction(); 
		
		ses.update(a);
		tx.commit();
	}
	
	public Appointment selectById(int id) {
		Session ses = HibernateUtil.getSession();
		Appointment myApp = ses.get(Appointment.class, id);
		return myApp;
	}
	
	public List<Appointment> selectAll() {
		Session ses = HibernateUtil.getSession();
		List<Appointment> appList = ses.createQuery("from Appointment").list();
		return appList;
	}
	
}
