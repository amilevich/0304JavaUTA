package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.util.HibernateUtil;
import com.example.model.Character;


public class CharacterDao {	

	public CharacterDao() {
		// TODO Auto-generated constructor stub
	}
	
	public void insert(Character myChar) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(myChar);
		tx.commit();
	}
	
	public Character selectById(int id) {
		Session ses = HibernateUtil.getSession();
		
		Character myChar = ses.get(Character.class, id);
		return myChar;
	}
	
	public List<Character> selectAll() {
		Session ses = HibernateUtil.getSession();
		
		/*
		 * HQL - hibernate Query Language
		 *  It is an object-oriented query language similar to SQL.
		 *  It works with persistent objects and their properties, 
		 *  as opposed to database tables.
		 */
//		List<Character> charList = ses.createQuery("from Character").list();
		
		List<Character> charList = ses.createCriteria(Character.class).list();
		return charList;
	}
	
	public Character selectByName(String name) {
		Session ses = HibernateUtil.getSession();
		
		//HQL
		// uses class names instead of table names
		List<Character> charList = ses.createQuery("from Character where name="+name, Character.class).list();
		// could use a SELECT to return a string specifically
		
		//Criteria API
//		name="Han Solo";
//		List<Character> charList = ses.createCriteria(Character.class) .add(Restrictions.like("name", name)).list();
		
		Character myChar = charList.get(0);
		return myChar;
		
	}
}
