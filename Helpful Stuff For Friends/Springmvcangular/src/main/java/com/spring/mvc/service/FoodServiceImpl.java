package com.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.component.Food;
import com.spring.mvc.repository.FoodDao;

@Service
public class FoodServiceImpl {

	
	@Autowired
	FoodDao fooddao;
	
	public List<Food> getAllFoods(){
		return fooddao.selectAllFromDb();
	}
}
