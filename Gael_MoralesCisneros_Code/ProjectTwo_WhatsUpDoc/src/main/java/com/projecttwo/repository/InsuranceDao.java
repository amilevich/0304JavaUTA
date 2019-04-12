package com.projecttwo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttwo.model.Insurance;
@Repository("insuranceRepo")
@Transactional
public class InsuranceDao {
	
	@Autowired
	private SessionFactory sesFact;
	
	public InsuranceDao() {
	}
	
	public void insert(Insurance insurance) {
		sesFact.getCurrentSession().save(insurance);
	}
	
	public Insurance selectById(int id) {
		return sesFact.getCurrentSession().get(Insurance.class, id);
	}
	
	public List<Insurance> selectAll(){
		List<Insurance> insurancelist = sesFact.getCurrentSession().createQuery("from Insurance", Insurance.class).list();
		return insurancelist;
	}

}
