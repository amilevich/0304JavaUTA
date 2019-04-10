package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.example.util.HibernateUtil;

import com.example.model.User;

/* 
 * Methods
 * 
 * save() and persist() //result in a sql insert
 * update() and merge() //result in a sql update
 * delete()             //result in a sql delete
 * saveOrUpdate()       //results in either insert or update (depending)
 * get() and load()     //result in a sql select
 * 
 */

public class UserDao {
	
	public UserDao() {
		
	}
	
	public void insert(User myUser) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(myUser); //this performs the INSERT INTO Characters VALUES(defined by myChar = char1 = ("nameString", "genderString", "motiveString", movList))
		tx.commit(); //transaction commit
	}
	
	public User selectById(int id) { //get method
		Session ses = HibernateUtil.getSession();
		
		User myUser = ses.get(User.class, id);
		return myUser;
	}
	
	public List<User> selectAll(){
		Session ses = HibernateUtil.getSession();
		
		List<User> userList = ses.createCriteria(User.class).list(); //crossed out because it's deprecated
		return userList;
	}
	
	public User selectByName(String name) {
        Session ses = HibernateUtil.getSession();
        
        Query<User> query = ses.createQuery("from User where name= :name"); //!!! MIGHT HAVE TO CHANGE TABLE NAME FROM "User" TO SOMETHING ELSE
        query.setParameter("name", name);
        
        List<User> list = query.list();
        return list.get(0);
    }
	
}