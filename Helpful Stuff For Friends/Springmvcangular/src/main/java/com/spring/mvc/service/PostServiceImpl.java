package com.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.component.Post;
import com.spring.mvc.repository.PostDao;

@Service
public class PostServiceImpl {

	
	@Autowired
	PostDao postdao;
	
	public List<Post> getAllPosts() {
		return postdao.selectAllFromDb();
	}
}
