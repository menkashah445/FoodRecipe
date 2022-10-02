package com.example.foodrecipes.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrecipes.Models.ExtendedIngredient;
import com.example.foodrecipes.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ingredientsAdapter extends  RecyclerView.Adapter<IngredientsViewHolder>  {
     Context Context;
     List<ExtendedIngredient> list;

    public ingredientsAdapter(android.content.Context context, List<ExtendedIngredient> list) {
        Context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public IngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IngredientsViewHolder (LayoutInflater.from (Context).inflate (R.layout.list_meal_ingredients,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsViewHolder holder, int position) {
        holder.textView_ingredients_name.setText (list.get (position).name);
        holder.textView_ingredients_quantity.setText (list.get (position).original);
        Picasso.get ().load ("https://spoonacular.com/cdn/ingredients_100x100/"+list.get (position).image).into (holder.imageView_Ingredients);

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class IngredientsViewHolder extends RecyclerView.ViewHolder{
    TextView textView_ingredients_quantity,textView_ingredients_name;
    ImageView imageView_Ingredients;

    public IngredientsViewHolder(@NonNull View itemView) {
        super (itemView);
        textView_ingredients_quantity = itemView.findViewById (R.id.textView_ingredients_quantity);
        textView_ingredients_name = itemView.findViewById (R.id.textView_ingredients_name);
        imageView_Ingredients = itemView.findViewById (R.id.imageView_Ingredients);

    }
}
