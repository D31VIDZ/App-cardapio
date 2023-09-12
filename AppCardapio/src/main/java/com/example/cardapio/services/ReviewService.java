package com.example.cardapio.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cardapio.dtos.ReviewDTO;
import com.example.cardapio.entitie.Review;
import com.example.cardapio.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	public List<Review> findbyFood_id(Long foodid) {
		return repository.findByFood_id(foodid);
	}
	
	public void createReviews(ReviewDTO review) {
		Review revi = new Review(review);
		this.add(revi);
	}
	
	public List<Review> getReviewsForFood(Long foodId){
		return this.findbyFood_id(foodId);
	}
	
	public Review add(Review review) {
		return repository.save(review);
	}
}