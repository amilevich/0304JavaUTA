package com.projecttwo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttwo.model.Specialty;

@Repository("specialtyRepo")
@Transactional
public class SpecialtyDao {
	
	@Autowired
	private SessionFactory sesFact;
	
	public SpecialtyDao() {
	}
	
	public void insert(Specialty specialty) {
		sesFact.getCurrentSession().save(specialty);
	}
	
	public Specialty selectById(int id) {
		return sesFact.getCurrentSession().get(Specialty.class, id);
	}
	
	public List<Specialty> selectAll(){
		List<Specialty> specialtylist = sesFact.getCurrentSession().createQuery("from Specialty", Specialty.class).list();
		return specialtylist;
	}

}
