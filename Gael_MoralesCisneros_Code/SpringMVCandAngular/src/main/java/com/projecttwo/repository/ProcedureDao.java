package com.projecttwo.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.projecttwo.model.Procedure;
import com.projecttwo.util.HibernateUtil;

@Repository
public class ProcedureDao {
	
	public void insert(Procedure pro) {

		Session ses = HibernateUtil.getSession();

		Transaction tx = ses.beginTransaction();

		ses.save(pro);

		tx.commit();

	}

	public void update(Procedure pro) {

		Session ses = HibernateUtil.getSession();

		Transaction tx = ses.beginTransaction();

		ses.update(pro);

		tx.commit();

	}

	public Procedure selectById(int id) {

		Session ses = HibernateUtil.getSession();

		Procedure myPro = ses.get(Procedure.class, id);

		return myPro;

	}

	public List<Procedure> selectAll() {

		Session ses = HibernateUtil.getSession();

		List<Procedure> proList = ses.createQuery("from Procedure ").list();

		return proList;

	}

}
