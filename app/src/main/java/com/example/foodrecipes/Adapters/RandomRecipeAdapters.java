package com.example.foodrecipes.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrecipes.Models.Recipe;
import com.example.foodrecipes.R;
import com.example.foodrecipes.RandomResponseListeners.RecipeClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RandomRecipeAdapters  extends RecyclerView.Adapter<RandomRecipeAdapters.RandomRecipeViewHolder>{
   Context context;
    List<Recipe>list;
    RecipeClickListener listener;


    public RandomRecipeAdapters(Context context, List<Recipe> list,RecipeClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }





    @NonNull
    @Override
    public RandomRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RandomRecipeViewHolder
                (LayoutInflater.from (context).inflate (R.layout.list_random_recipe,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RandomRecipeViewHolder holder, int position) {
        holder.title.setText (list.get(position).title);
        holder.title.setSelected (true);
        holder.likes.setText (list.get(position).aggregateLikes + "Likes");
        holder.serving.setText (list.get(position).servings + " serving");
        holder.time.setText (list.get(position).readyInMinutes+ "Minutes");
//        Picasso.get().load(list.get(position).image.into(holder.imageView_food));
        Picasso.get ().load(list.get (position).image).into (holder.imageView_food);
        holder.list_item.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                listener.onRecipeClicked (String.valueOf (list.get(holder.getAdapterPosition ()).id));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

     class RandomRecipeViewHolder extends RecyclerView.ViewHolder{
        CardView list_item;
        TextView title, serving,likes,time;
        ImageView imageView_food;

        public RandomRecipeViewHolder(@NonNull View itemView) {
            super (itemView);
            list_item  = itemView.findViewById (R.id.list_item);
            title = itemView.findViewById (R.id.title);
            serving = itemView.findViewById (R.id. serving);
            likes = itemView.findViewById (R.id.likes);
            time = itemView.findViewById (R.id.time);
            imageView_food = itemView.findViewById (R.id.imageView_food);


        }
    }

}
