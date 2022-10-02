package com.example.foodrecipes;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrecipes.Models.RecipeDetailsResponse;
import com.example.foodrecipes.RandomResponseListeners.RecipeDetailsListener;
import com.squareup.picasso.Picasso;


public class RecipeDetailsActivity extends AppCompatActivity {
    int id;
    TextView textView_mealName,textView_mealSource,textView_mealSummary,textView_ingredients;
    ImageView imageView_mealImage;
    RecyclerView meal_ingredients;
//    ProgressBar progressBar;
    RequestManager manager;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_recipe_details);
        findViews ();

        id = Integer.parseInt (getIntent ().getStringExtra ("id"));
        manager = new RequestManager (this);
        manager.getRecipeDetails (recipeDetailsListener,id);
        dialog = new ProgressDialog (this);
        dialog.setTitle ("loading Deatils.... ");
        dialog.show ();

    }
     private  void findViews(){
         textView_mealName = findViewById (R.id.textView_mealName);
         textView_mealSource = findViewById (R.id.textView_mealSource);
         textView_mealSummary =findViewById (R.id.textView_mealSummary);
         imageView_mealImage =findViewById (R.id. imageView_mealImage);
         meal_ingredients = findViewById (R.id.meal_ingredients);

    }
    private  final RecipeDetailsListener recipeDetailsListener = new RecipeDetailsListener () {
        @Override
        public void didFtech(RecipeDetailsResponse response, String message) {
            dialog.dismiss ();
            textView_mealName.setText (response.title);
            textView_mealName.setText (response.sourceName);
            textView_mealName.setText (response.summary);
            Picasso.get ().load (response.image).into (imageView_mealImage);

        }

        @Override
        public void didError(String message) {

        }
    };
}