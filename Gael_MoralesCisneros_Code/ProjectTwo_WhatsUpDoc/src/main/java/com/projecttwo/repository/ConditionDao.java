package com.projecttwo.repository;

import java.util.List;
import java.util.concurrent.locks.Condition;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("conditionRepo")
@Transactional
public class ConditionDao {
	
	@Autowired
	private SessionFactory sesFact;
	
	public ConditionDao() {
	}
	
	public void insert(Condition condition) {
		sesFact.getCurrentSession().save(condition);
	}
	
	public Condition selectById(int id) {
		return sesFact.getCurrentSession().get(Condition.class, id);
	}
	
	public List<Condition> selectAll(){
		List<Condition> conditionlist = sesFact.getCurrentSession().createQuery("from Condition", Condition.class).list();
		return conditionlist;
	}

}
