package com.example.foodrecipes.Models;

import java.util.ArrayList;

public class Step<Equipment> {
    public int number;
    public String step;
    public ArrayList<Ingredient> ingredients;
    public ArrayList<Equipment> equipment;
    public Length length;
}
