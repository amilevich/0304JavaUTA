package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Food;
import com.example.repository.FoodDao;

@Controller
public class FoodController {
	
	@Autowired
	private FoodDao foodDao;
	
	public FoodController() {
	}
	
	/*
	 * @RequestMapping - tells the HandlerMapping
	 * the controller method to go to based on the URI
	 * of the HTTP request passed to it by the 
	 * DispatcherServlet
	 * Attributes you can set for it include:
	 * - Value - indicates the URL to which the handler method
	 * is mapped
	 * - Method - defines the type of HTTP request it is 
	 * intended to handle (Get, post, put, delete...)
	 */

//	@RequestMapping(value="/getAllFood.app", method = RequestMethod.GET)
	@GetMapping(value = "/getAllFood.app")
	public @ResponseBody List<Food> getAllFoods(){
		return foodDao.selectAll();
	}
	
	@RequestMapping(value="/getFoodById.app", method = RequestMethod.POST, produces="application/json", params = {"id"})
	public ResponseEntity<Food> getFoodById(int id){
		return new ResponseEntity<Food>(foodDao.selectById(id), HttpStatus.OK);
	}
	
//	@PostMapping(value="/getFoodById.app")
//	public @ResponseBody Food getFoodById(@RequestParam("id")int num) {
//		return foodDao.selectById(num);
//	}
	
	@PostMapping(value= "{num}/getFoodByUri.app")
	public @ResponseBody Food getFoodByUri(@PathVariable("num") int num) {
		return foodDao.selectById(num);
	}
}