package com.projecttwo.util;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * CORE INTERFACES OF HIBERNATE
 * 
 * (class)
 * Configuration - its job is to gather info from hibernate.cfg.xml and is used
 *  to create a session factory
 *  
 * (interface)
 * SessionFactory - its job is to create sessions and store info on how to make
 *  connections to your database. Once it is configured, it is immutable.
 *   
 * (interface)
 * Session - its job is to manage the connections to your database and to provide
 *  the CRUD operations.
 *  
 * (interface) 
 * Transaction - its job is to manage your transactions and cache
 *  (must be ACID) 
 *  
 * Found in DAO:
 *  
 * (interface)
 * Criteria API - a criteria object is used to create and execute object-oriented
 *  queries to retrieve objects from the db.
 *  
 * (interface) 
 * Query - uses a combination of object oriented programming and SQL.
 *  Database independent.
 *  
 */



public class HibernateUtil {

	private static Session ses;
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	
	public static Session getSession() {
		if(ses == null) {
			ses = sf.openSession();
		}
		return ses;
	}
	
	public static void coseSes() {
		ses.close();
	}
	
	
}
