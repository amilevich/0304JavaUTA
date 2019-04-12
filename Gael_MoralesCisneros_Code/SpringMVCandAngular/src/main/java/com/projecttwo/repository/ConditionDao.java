package com.projecttwo.repository;

import java.util.List;
import java.util.concurrent.locks.Condition;


import org.hibernate.Session;
import org.hibernate.Transaction;

import org.springframework.stereotype.Repository;

import com.projecttwo.util.HibernateUtil;


@Repository
public class ConditionDao {

	public void insert(Condition con) {

		Session ses = HibernateUtil.getSession();

		Transaction tx = ses.beginTransaction();

		ses.save(con);

		tx.commit();

	}

	public void update(Condition con) {

		Session ses = HibernateUtil.getSession();

		Transaction tx = ses.beginTransaction();

		ses.update(con);

		tx.commit();

	}

	public Condition selectById(int id) {

		Session ses = HibernateUtil.getSession();

		Condition myCon = ses.get(Condition.class, id);

		return myCon;

	}

	public List<Condition> selectAll() {

		Session ses = HibernateUtil.getSession();

		List<Condition> conList = ses.createQuery("from Condition").list();

		return conList;

	}

}
