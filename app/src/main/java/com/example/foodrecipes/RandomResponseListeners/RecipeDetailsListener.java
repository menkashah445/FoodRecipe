package com.example.foodrecipes.RandomResponseListeners;

import com.example.foodrecipes.Models.RecipeDetailsResponse;


public interface RecipeDetailsListener {
    void didFtech(RecipeDetailsResponse response,String message);
    void didError(String message);
}
