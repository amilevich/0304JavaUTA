package com.spring.mvc.component;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Comments")
public class Comment {
	
	@Id
	@Column(name = "comment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentId;
	
	@Column(name = "comment_body")
	private String commentBody;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "post_id")
	@JsonBackReference
	private Post postss;
	
//	@Column(name = "post_id")
//	private int postId;
	
	public Comment() {
	}
	
	

	public Comment(String commentBody, Post postss) {
		super();
		this.commentBody = commentBody;
		this.postss = postss;
	}



	public Comment(int commentId, String commentBody, Post postss) {
		super();
		this.commentId = commentId;
		this.commentBody = commentBody;
		this.postss = postss;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentBody=" + commentBody + ", postss=" + postss + "]";
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentBody() {
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	public Post getPostss() {
		return postss;
	}

	public void setPostss(Post postss) {
		this.postss = postss;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
