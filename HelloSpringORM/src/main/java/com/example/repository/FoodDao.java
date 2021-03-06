package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Food;


/*
 * tells Spring that the method or class creates
 * transactions. Spring will then create and manage
 * your sessions and commits for you.
 */
@Repository("foodRepo")
@Transactional 
public class FoodDao {
	
	@Autowired
	private SessionFactory sesFact;
	
	public FoodDao() {
	}
	
	public void insert(Food food) {
		sesFact.getCurrentSession().save(food);
	}
	
	public void update(Food food) {
		sesFact.getCurrentSession().update(food);
	}
	
	public Food selectById(int id) {
		return sesFact.getCurrentSession().get(Food.class, id);
	}
	
	public List<Food> selectAll(){
		List<Food> foodList = sesFact.getCurrentSession().createQuery("from Food", Food.class).list();
		return foodList;
	}

}
