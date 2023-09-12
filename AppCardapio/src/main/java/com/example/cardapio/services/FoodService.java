package com.example.cardapio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cardapio.dtos.FoodDTO;
import com.example.cardapio.entitie.Food;
import com.example.cardapio.entitie.Review;
import com.example.cardapio.repositories.FoodRepository;

@Service
public class FoodService {

	@Autowired
	private FoodRepository repository;
	
	@Autowired
	private ReviewService service;
	
	public void createFoods(FoodDTO fod) {
		Food newFood = new Food(fod);
		this.saveFoods(newFood);
	}
	
	public List<Food> getAll(){
		return this.repository.findAll();
	}
	
	public Food getFoodById(Long id) throws Exception{
		return this.repository.findById(id).orElseThrow(() -> new Exception("Comida não encontrada"));
	}

	public void saveFoods(Food fod) {
		this.repository.save(fod);
	}
}