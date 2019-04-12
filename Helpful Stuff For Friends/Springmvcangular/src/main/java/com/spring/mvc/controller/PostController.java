package com.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mvc.component.Food;
import com.spring.mvc.component.Post;
import com.spring.mvc.service.PostServiceImpl;

@Controller
public class PostController {

	@Autowired
	PostServiceImpl postService;
	
	public PostController() {
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/getAllPosts.app")
	public @ResponseBody List<Post> getAllPosts(){
		return postService.getAllPosts();
	}
	
}
