package com.example.cardapio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.dtos.FoodDTO;
import com.example.cardapio.dtos.FoodDetailDTO;
import com.example.cardapio.entitie.Food;
import com.example.cardapio.entitie.Review;
import com.example.cardapio.services.FoodService;
import com.example.cardapio.services.ReviewService;

@RestController
@RequestMapping(path = "/foods")
public class FoodController {
	
	@Autowired
	private FoodService service;
	
	@Autowired
	private ReviewService rService;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<Food> getAllFood() {
		List<Food> foodList = service.getAll();
		return foodList;
	}
	
	@GetMapping("/{foodId}")
	public ResponseEntity<FoodDetailDTO> getFoodDetail(@PathVariable Long foodId) throws Exception{
		Food food = service.getFoodById(foodId);
		
		List<Review> reviews = rService.getReviewsForFood(foodId);
		
		FoodDetailDTO detail = new FoodDetailDTO(food, reviews);		
		
		return ResponseEntity.ok(detail);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody FoodDTO SetFood(@Valid FoodDTO fod) {
		
		service.createFoods(fod);
		return fod;
	}
	
//	@CrossOrigin(origins = "*", allowedHeaders = "*")
//	@DeleteMapping("/{id}")
//	public void deletFood(@PathVariable Long id) {
//		Service.deleteById(id);
//	}
}