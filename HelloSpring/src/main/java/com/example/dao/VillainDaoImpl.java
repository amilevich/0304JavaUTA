package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.Villain;

/*
 * Spring annotations
 * - allow you to configure the dependency
 * injection by moving bean configuration
 * into the component class itself
 */

@Repository("villainDao")
public class VillainDaoImpl implements VillainDao{

	@Override
	public List<Villain> SelectAll() {
		List<Villain> listV = new ArrayList<>();
		
		listV.add(new Villain("Mysterio","Mystery", false));
		listV.add(new Villain("Pupper","Cuteness", false));
		listV.add(new Villain("KJS","JavaScript", true));
		listV.add(new Villain("Jim","Eggs", true));
		return listV;
	}
	
	/*
	 * this method is a mock DAO impl.
	 */
	

}
