package com.example.foodrecipes.RandomResponseListeners;

import com.example.foodrecipes.Models.RandomRecipeApiKey;

public interface RandomRecipeResponseListener {
    void didFetch(RandomRecipeApiKey response, String message);
    void didErro(String message);
}
