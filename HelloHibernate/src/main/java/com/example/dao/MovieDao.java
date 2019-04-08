package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Movie;
import com.example.util.HibernateUtil;

public class MovieDao {

	public MovieDao() {
		// TODO Auto-generated constructor stub
	}
	
	public void insert(Movie mov) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(mov);
		tx.commit();
		
//		ses.close();
	}
	
	public void update(Movie mov) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction(); 
		
		ses.update(mov);
		tx.commit();
	}
	
	public Movie selectById(int id) {
		Session ses = HibernateUtil.getSession();
		Movie myMov = ses.get(Movie.class, id);
		return myMov;
	}
	
	public List<Movie> selectAll() {
		Session ses = HibernateUtil.getSession();
		List<Movie> movList = ses.createQuery("from Movie").list();
		return movList;
	}
}

/*
 * Methods 
 * 
 * save() and persist()		result in a sql insert
 * update() and merge() 	result in a sql update
 * delete()					result in a sql delete
 * saveOrUpdate()			result in either insert or update (depending)
 * get() and load()			result in a sql select
 * 
 * 
 * Use update() if you are sure that the session does not contain an 
 * 	already persistent instance with the same identifier
 * Use merger() if you want to merge your modifications at any time
 * 	without consideration of the state of the session
 * 
 * update() will not allow duplicate ids inside of your cache
 * merger() will insert into the cache or overwrite the existing cache value
 * 
 * 
 * Only use load() method if your are sure that the object exists. load() will
 * 	throw an exception if the unique id is not found in the database
 * 	load() just returns a proxy (placeholder for a future value) by default
 * 	and database won't be 'hit' until the proxy is first invoked
 * 
 * if your are not sure that the object exists, then use the get() method
 * 	get() method will return null if the unique id is not found in the db.
 * 	get() will 'hit' the database immediately.
 * 
 */
