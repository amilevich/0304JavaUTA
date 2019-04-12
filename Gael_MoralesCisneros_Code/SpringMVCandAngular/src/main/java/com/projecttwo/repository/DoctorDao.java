package com.projecttwo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttwo.util.HibernateUtil;
import com.projecttwo.model.Doctor;

@Repository
public class DoctorDao {
	
	public void insert(Doctor dir) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(dir);
		tx.commit();
		
	}
	
	public void update(Doctor dir) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction(); 
		
		ses.update(dir);
		tx.commit();
	}
	
	public Doctor selectById(int id) {
		Session ses = HibernateUtil.getSession();
		Doctor myDir = ses.get(Doctor.class, id);
		return myDir;
	}
	
	public List<Doctor> selectAll() {
		Session ses = HibernateUtil.getSession();
		List<Doctor> dirList = ses.createQuery("from Doctor").list();
		return dirList;
	}

	public Doctor selectByUsernameAndPassword(String un, String pw) {
		Session ses = HibernateUtil.getSession();
		List<Doctor> dList = ses.createQuery("from Doctor where username="+un+" and password="+pw,Doctor.class).list();

        return dList.get(0);
	}
	

}
