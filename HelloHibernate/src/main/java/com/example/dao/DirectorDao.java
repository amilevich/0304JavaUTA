package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Director;
import com.example.util.HibernateUtil;

public class DirectorDao {
	public DirectorDao() {
	}

	public void insert(Director dirc) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.save(dirc);

		tx.commit();
		/* ses.close(); */
	}

	public void update(Director dirc) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();

		ses.update(dirc);

		tx.commit();
		/* ses.close(); */
	}

	public Director selectbyId(int id) {
		Session ses = HibernateUtil.getSession();

		Director mydirc = ses.get(Director.class, id);

		/* ses.close(); */
		return mydirc;
	}

	public List<Director> selectAll() {
		Session ses = HibernateUtil.getSession();

		List<Director> dircList = ses.createQuery("from Director").list();

		/* ses.close(); */
		return dircList;
	}
}
