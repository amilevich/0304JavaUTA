package com.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mvc.component.Comment;
import com.spring.mvc.component.Post;
import com.spring.mvc.service.CommentServiceImpl;

@Controller
public class CommentController {

	
	@Autowired
	CommentServiceImpl commentService;
	
	public CommentController() {
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/getAllComments.app")
	public @ResponseBody List<Comment> getAllComments(){
		System.out.println("hi from controller: " + commentService.getAllComments());
		return commentService.getAllComments();
	}
	
}
