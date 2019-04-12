package com.projecttwo.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.projecttwo.model.Insurance;
import com.projecttwo.util.HibernateUtil;

@Repository
public class InsuranceDao {
	
	public void insert(Insurance ins) {

		Session ses = HibernateUtil.getSession();

		Transaction tx = ses.beginTransaction();

		ses.save(ins);

		tx.commit();

	}

	public void update(Insurance ins) {

		Session ses = HibernateUtil.getSession();

		Transaction tx = ses.beginTransaction();

		ses.update(ins);

		tx.commit();

	}

	public Insurance selectById(int id) {

		Session ses = HibernateUtil.getSession();

		Insurance myIns = ses.get(Insurance.class, id);

		return myIns;

	}

	public List<Insurance> selectAll() {

		Session ses = HibernateUtil.getSession();

		List<Insurance> insList = ses.createQuery("from Insurance ").list();

		return insList;

	}


}
