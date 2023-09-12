package com.example.cardapio.dtos;

import java.util.List;

import com.example.cardapio.entitie.Food;
import com.example.cardapio.entitie.Review;

public record FoodDetailDTO(Food food, List<Review> reviews) {
	
	public FoodDetailDTO(Food food, List<Review> reviews) {
        this.food = food;
        this.reviews = reviews;
    }
}
