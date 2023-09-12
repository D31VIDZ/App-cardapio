package com.example.cardapio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.dtos.ReviewDTO;
import com.example.cardapio.entitie.Review;
import com.example.cardapio.services.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	@Autowired
	ReviewService service;
	
	@GetMapping("/{foodId}")
	public ResponseEntity<List<Review>> getReviewForFood(@PathVariable Long foodId){
		List<Review> reviews = service.getReviewsForFood(foodId);
		return ResponseEntity.ok(reviews);	
	}
	
	@PostMapping
	public @ResponseBody ReviewDTO addReview(@RequestBody @Valid ReviewDTO revie){
		
		service.createReviews(revie);
		return revie;
	}
}