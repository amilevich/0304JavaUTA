package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.VillainDao;
import com.example.model.Villain;

/*
 * component, repository, controller, service,
 * configuration 
 * Stereotypes
 */

@Service("villainService")
public class VillainServiceImpl implements VillainService{
	// Old way, without DI
	//private VillainDao vDao = new VillainDao();
	
	private VillainDao villainDao;
	
	@Override
	public List<Villain> getAllVillains() {
		return villainDao.SelectAll();
	}
	
	public VillainServiceImpl() {
		System.out.println("no args constructor");
	}
	
	@Autowired
	// using autowired above a constructor
	// tells spring to attempt autowiring
	// using this constructor
	public VillainServiceImpl(VillainDao vDao) {
		// DI constructor 
		this.villainDao = vDao; 
	}
	
	@Autowired
	public VillainDao getVillainDao() {
		return villainDao;
	}
	
	@Autowired
	// using autowired above a setter tells
	// spring to attempt byType then byName
	public void setVillainDao(VillainDao vDao) {
		this.villainDao = vDao;
	}
	
	public VillainServiceImpl(VillainDao vDao, int num) {
		//DI constructor with int
		this.villainDao = vDao;
	}

}
