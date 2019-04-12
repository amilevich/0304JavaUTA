package com.projecttwo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projecttwo.model.Procedure;

@Repository("ProcedureRepo")
@Transactional
public class ProcedureDao {
	
	@Autowired
	private SessionFactory sesFact;
	
	public ProcedureDao() {
	}
	
	public void insert(Procedure procedure) {
		sesFact.getCurrentSession().save(procedure);
	}
	
	public Procedure selectById(int id) {
		return sesFact.getCurrentSession().get(Procedure.class, id);
	}
	
	public List<Procedure> selectAll(){
		List<Procedure> procedurelist = sesFact.getCurrentSession().createQuery("from Procedure", Procedure.class).list();
		return procedurelist;
	}

}
