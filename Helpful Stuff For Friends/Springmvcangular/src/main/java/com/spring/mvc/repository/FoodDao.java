package com.spring.mvc.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.component.Food;

@Repository("foodDao")
@Transactional
@EnableTransactionManagement
public class FoodDao {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
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
		Food food = sesFact.getCurrentSession().get(Food.class, id);
		return food;
	}
	
	
	public List<Food> selectAllFromDb() {
		System.out.println("Hi");
		List<Food> foodList = sesFact.getCurrentSession().createQuery("from Food", Food.class).list();
		System.out.println(foodList);
		return foodList;
	}
	
}
