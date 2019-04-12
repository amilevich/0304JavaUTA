package com.projecttwo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttwo.model.User;

@Repository("userRepo")
@Transactional
public class UserDao {
	
	@Autowired
	private SessionFactory sesFact;
	
	public UserDao() {
	}
	
	public void insert(User user) {
		sesFact.getCurrentSession().save(user);
	}
	
	public User selectById(int id) {
		return sesFact.getCurrentSession().get(User.class, id);
	}
	
	public List<User> selectAll(){
		List<User> userlist = sesFact.getCurrentSession().createQuery("from User", User.class).list();
		return userlist;
	}
	

}
