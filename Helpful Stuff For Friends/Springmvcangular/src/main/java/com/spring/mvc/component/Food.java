package com.spring.mvc.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Food")
public class Food {
	
	@Id
	@Column(name="food_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodId;
	
	@Column(name="dish_name", unique=true, nullable = false)
	private String dishName;
	
	@Column(name="calories", nullable = false)
	private float calories;

	@Column(name="picture", nullable = true)
	private String picture;
	
	public Food() {
		
	}
	
	public Food(String dishName, float calories) {
		super();
		this.dishName = dishName;
		this.calories = calories;
	}



	public Food(int foodId, String dishName, float calories, String picture) {
		super();
		this.foodId = foodId;
		this.dishName = dishName;
		this.calories = calories;
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", dishName=" + dishName + ", calories=" + calories + ", picture=" + picture
				+ "]";
	}

	
	
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public float getCalories() {
		return calories;
	}

	public void setCalories(float calories) {
		this.calories = calories;
	}
	
	
}
