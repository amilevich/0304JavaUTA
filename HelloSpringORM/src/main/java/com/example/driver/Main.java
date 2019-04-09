package com.example.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.model.Food;
import com.example.repository.FoodDao;

/*
 * Spring ORM is a Spring module that allows
 * Spring to manage another ORM framework in 
 * your place.
 * In our case, we let Spring ORM manage
 * Hibernate.
 */
public class Main {
	
	public static ApplicationContext appContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	public static FoodDao foodDao = appContext.getBean("foodRepo", FoodDao.class);

	public static void main(String[] args) {
		insertInitialValues();
		System.out.println("All our foods: " + foodDao.selectAll());
	}
	
	public static void insertInitialValues() {
		//inserting our foodz
		
		Food food1 = new Food("Fajitas", 2);
		foodDao.insert(food1);
		
		Food food2 = new Food("Monster",0);
		foodDao.insert(food2);
		
		Food food3 = new Food("Crackers", 2.0);
		foodDao.insert(food3);
		
		Food food4 = new Food("Pizza", 285.94);
		foodDao.insert(food4);
	}

}
