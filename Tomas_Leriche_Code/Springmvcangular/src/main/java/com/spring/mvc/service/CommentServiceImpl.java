package com.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.component.Comment;
import com.spring.mvc.repository.CommentDao;

@Service
public class CommentServiceImpl {

	@Autowired
	CommentDao commentdao;
	
	public List<Comment> getAllComments() {
		System.out.println("Hi from commentServiceImpl");
		System.out.println(commentdao.selectAllFromDb());
		return commentdao.selectAllFromDb();
	}
	
}
