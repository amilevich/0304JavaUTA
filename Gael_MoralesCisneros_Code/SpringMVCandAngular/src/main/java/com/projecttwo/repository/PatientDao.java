package com.projecttwo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttwo.model.Appointment;
import com.projecttwo.model.Doctor;
import com.projecttwo.model.Patient;
import com.projecttwo.util.HibernateUtil;

@Repository
public class PatientDao {
	

	
	public void insert(Patient p) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(p);
		tx.commit();
		
	}
	
	public void update(Patient p) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction(); 
		
		ses.update(p);
		tx.commit();
	}
	
	public Patient selectById(int id) {
		Session ses = HibernateUtil.getSession();
		Patient myPat = ses.get(Patient.class, id);
		return myPat;
	}
	
	public List<Patient> selectAll() {
		Session ses = HibernateUtil.getSession();
		List<Patient> patList = ses.createQuery("from Patient").list();
		return patList;
	}
	
	public Patient selectByUsernameAndPassword(String un, String pw) {
		Session ses = HibernateUtil.getSession();
		List<Patient> pList = ses.createCriteria(Patient.class) .add(Restrictions.like("userName", un)).add(Restrictions.like("passWord", pw)).list();
		if (pList.isEmpty()) {
			return null;
		}
		else {
			return pList.get(0);
		}
	}

}
