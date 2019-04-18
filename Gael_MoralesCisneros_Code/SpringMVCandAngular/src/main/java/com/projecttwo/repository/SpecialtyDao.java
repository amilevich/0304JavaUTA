package com.projecttwo.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.projecttwo.model.Condition;
import com.projecttwo.model.Procedure;
import com.projecttwo.model.Specialty;
import com.projecttwo.util.HibernateUtil;

@Repository
public class SpecialtyDao {
	

	public void insert(Specialty spe) {

		Session ses = HibernateUtil.getSession();

		Transaction tx = ses.beginTransaction();

		ses.save(spe);

		tx.commit();

	}

	public void update(Specialty spe) {

		Session ses = HibernateUtil.getSession();

		Transaction tx = ses.beginTransaction();

		ses.update(spe);

		tx.commit();

	}

	public Specialty selectById(int id) {

		Session ses = HibernateUtil.getSession();

		Specialty mySpe = ses.get(Specialty.class, id);

		return mySpe;

	}

	public List<Specialty> selectAll() {

		Session ses = HibernateUtil.getSession();

		List<Specialty> speList = ses.createQuery("from Specialty ").list();

		return speList;

	}
	
//	public List<Procedure> selectAllProcedures() {
//		Session ses = HibernateUtil.getSession();
//
//		List<Procedure> proList = ses.createQuery("from Procedure ").list();
//
//		return proList;
//	}
	

//	public List<Condition> selectAllConditions() {
//
//		Session ses = HibernateUtil.getSession();
//
//		List<Condition> conList = ses.createQuery("from Condition").list();
//
//		return conList;
//
//	}

}
