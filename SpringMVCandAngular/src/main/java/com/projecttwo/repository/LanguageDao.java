package com.projecttwo.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.projecttwo.model.Language;
import com.projecttwo.util.HibernateUtil;

@Repository
public class LanguageDao {

	public void insert(Language lan) {

		Session ses = HibernateUtil.getSession();

		Transaction tx = ses.beginTransaction();

		ses.save(lan);

		tx.commit();

	}

	public void update(Language lan) {

		Session ses = HibernateUtil.getSession();

		Transaction tx = ses.beginTransaction();

		ses.update(lan);

		tx.commit();

	}

	public Language selectById(int id) {

		Session ses = HibernateUtil.getSession();

		Language myLan = ses.get(Language.class, id);

		return myLan;

	}

	public List<Language> selectAll() {

		Session ses = HibernateUtil.getSession();

		List<Language> lanList = ses.createQuery("from Language ").list();

		return lanList;

	}


}
