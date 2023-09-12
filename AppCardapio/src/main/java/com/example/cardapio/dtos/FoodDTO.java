package com.example.cardapio.dtos;

import com.example.cardapio.entitie.Food;

public record FoodDTO(String title, String image, Double price) {
	
	public FoodDTO(Food fod) {
		this(fod.getTitle(), fod.getImage(), fod.getPrice());
	}

}
