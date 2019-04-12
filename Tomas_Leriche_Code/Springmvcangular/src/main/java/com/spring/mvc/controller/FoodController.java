package com.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mvc.component.Food;
import com.spring.mvc.repository.FoodDao;
import com.spring.mvc.service.FoodServiceImpl;

@Controller
public class FoodController {
	
//	@Autowired
//	private FoodDao foodDao;
	
	@Autowired
	FoodServiceImpl foodService;
	
	public FoodController() {
	}
	
//	@RequestMapping(value="/getAllFood.app", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/getAllFood.app")
	public @ResponseBody List<Food> getAllFoods(){
		return foodService.getAllFoods();
	}
	
//	@RequestMapping(value="/getFoodById.app", method = RequestMethod.POST, produces="application/json", params = {"id"})
//	public ResponseEntity<Food> getFoodById(int id){
//		return new ResponseEntity<Food>(foodDao.selectById(id), HttpStatus.OK);
//	}
	
//	@PostMapping(value="/getFoodById.app")
//	public @ResponseBody Food getFoodById(@RequestParam("id")int num) {
//		return foodDao.selectById(num);
//	}
	
//	@PostMapping(value= "{num}/getFoodByUri.app")
//	public @ResponseBody Food getFoodByUri(@PathVariable("num") int num) {
//		return foodDao.selectById(num);
//	}
}