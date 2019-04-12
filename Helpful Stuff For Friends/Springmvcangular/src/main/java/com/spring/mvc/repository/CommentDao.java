package com.spring.mvc.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.component.Comment;
import com.spring.mvc.component.Post;

@Repository("commentDao")
@Transactional
@EnableTransactionManagement
public class CommentDao {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	private SessionFactory sesFact;
	
	public CommentDao() {
	}
	
	public void insert(Comment comment) {
		sesFact.getCurrentSession().save(comment);
	}
	
	public void update(Comment comment) {
		sesFact.getCurrentSession().update(comment);
	}
	
	public Comment selectById(int id) {
		Comment comment = sesFact.getCurrentSession().get(Comment.class, id);
		return comment;
	}
	
	
	public List<Comment> selectAllFromDb() {
		System.out.println("Hi from CommentDao select all from DB");
		List<Comment> commentList = sesFact.getCurrentSession().createQuery("from Comment", Comment.class).list();
		System.out.println("COmment list " + commentList);
		return commentList;
	}
	
	
}
