package com.projecttwo.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

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

		List<Specialty> speList = ses.createQuery("from Specialist ").list();

		return speList;

	}

}
