package com.spring.mvc.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.component.Food;
import com.spring.mvc.component.Post;

@Repository("postDao")
@Transactional
@EnableTransactionManagement
public class PostDao {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	private SessionFactory sesFact;
	
	public PostDao() {
		
	}
	
	public void insert(Post post) {
		sesFact.getCurrentSession().save(post);
	}
	
	public void update(Post post) {
		sesFact.getCurrentSession().update(post);
	}
	
	public Post selectById(int id) {
		Post post = sesFact.getCurrentSession().get(Post.class, id);
		return post;
	}
	
	
	public List<Post> selectAllFromDb() {
		System.out.println("Hi from PostDao");
		List<Post> postList = sesFact.getCurrentSession().createQuery("from Post", Post.class).list();
		System.out.println(postList);
		return postList;
	}
	
	
}
