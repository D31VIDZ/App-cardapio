package com.example.cardapio.entitie;

import javax.validation.constraints.Max;

import javax.validation.constraints.Min;


import com.example.cardapio.dtos.ReviewDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "reviews")
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "id")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "food_id")
	@JsonBackReference
	private Food food;
	
	@Transient
	private Long foodId;
	
	private String message;
	
	private String reviewerName;
	
	@Min(0)
	@Max(5)
	private Integer note;
	
	public Review() {
	}

	public Review(ReviewDTO review) {
		this.foodId = review.foodId();
		this.message = review.message();
		this.note = review.note();
		this.reviewerName = review.reviewerName();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Food getFoodId() {
		return food;
	}

	public void setFoodId(Food food) {
		this.food = food;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}
}
