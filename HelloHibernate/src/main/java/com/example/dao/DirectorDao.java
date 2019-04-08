package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Director;
import com.example.util.HibernateUtil;

public class DirectorDao {

	public void insert(Director dir) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(dir);
		tx.commit();
		
//		ses.close();
	}
	
	public void update(Director dir) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction(); 
		
		ses.update(dir);
		tx.commit();
	}
	
	public Director selectById(int id) {
		Session ses = HibernateUtil.getSession();
		Director myDir = ses.get(Director.class, id);
		return myDir;
	}
	
	public List<Director> selectAll() {
		Session ses = HibernateUtil.getSession();
		List<Director> dirList = ses.createQuery("from Director").list();
		return dirList;
	}
}

