package com.spring.mvc.component;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Post")
public class Post {

	@Id
	@Column(name="post_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;
	
	@Column(name="author_id", nullable = false)
	private int authorId;
	
	@Column(name="post_body", nullable = false)
	private String postBody;
	
	@Column(name="post_media", nullable = true)
	private String postMedia;
	
	@OneToMany(mappedBy = "postss", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Comment> comments;
	
	public Post() {
		
	}

	
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", authorId=" + authorId + ", postBody=" + postBody + ", postMedia="
				+ postMedia + "]";
	}
	

	public Post(int postId, int authorId, String postBody, String postMedia, List<Comment> comments) {
		super();
		this.postId = postId;
		this.authorId = authorId;
		this.postBody = postBody;
		this.postMedia = postMedia;
		this.comments = comments;
	}

	
	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getPostBody() {
		return postBody;
	}

	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}

	public String getPostMedia() {
		return postMedia;
	}

	public void setPostMedia(String postMedia) {
		this.postMedia = postMedia;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
