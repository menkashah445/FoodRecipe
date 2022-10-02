package com.example.foodrecipes;

import android.content.Context;

import com.example.foodrecipes.Models.RandomRecipeApiKey;
import com.example.foodrecipes.Models.RecipeDetailsResponse;
import com.example.foodrecipes.RandomResponseListeners.RandomRecipeResponseListener;
import com.example.foodrecipes.RandomResponseListeners.RecipeDetailsListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class RequestManager {

    Context context;
    Retrofit Retrofit = new Retrofit.Builder ()
            .baseUrl ("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create ())
            .build ();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getRandomRecipes(RandomRecipeResponseListener listener,List<String> tags)
    {
        callRandomRecipes callRandomRecipes = Retrofit.create (RequestManager.callRandomRecipes.class);
        Call<RandomRecipeApiKey> call = callRandomRecipes.callRandomRecipe
                (context.getString (R.string.api_key),"100",tags);
        call.enqueue (new Callback<RandomRecipeApiKey> () {
            @Override
            public void onResponse(Call<RandomRecipeApiKey> call, Response<RandomRecipeApiKey> response) {
                if(! response.isSuccessful ()){
                    listener.didErro (response.message ());
                    return;
                }
                listener.didFetch (response.body (), response.message ());
            }

            @Override
            public void onFailure(Call<RandomRecipeApiKey> call, Throwable t) {
                listener.didErro (t.getMessage ());

            }
        });
    }
     public  void getRecipeDetails(RecipeDetailsListener listener, int id){
        callRecipeDetails callRecipeDetails = Retrofit.create (RequestManager.callRecipeDetails.class);
        Call<RecipeDetailsResponse> call = callRecipeDetails.callRecipeDetails (id,context.getString (R.string.api_key));
        call.enqueue (new Callback<RecipeDetailsResponse> () {
            @Override
            public void onResponse(Call<RecipeDetailsResponse> call, Response<RecipeDetailsResponse> response) {
                if(!response.isSuccessful ()){
                    listener.didError (response.message ());
                    return;
                }
                listener.didFtech (response.body (),response.message ());

            }

            @Override
            public void onFailure(Call<RecipeDetailsResponse> call, Throwable t) {
                listener.didError (t.getMessage ());


            }
        });

     }


    private  interface callRandomRecipes{
        @GET("recipes/random")
        Call<RandomRecipeApiKey> callRandomRecipe(

                @Query("apiKey") String apikey,
                @Query ("number") String number,
                @Query("tags") List<String>tags
                );
    }

    private  interface callRecipeDetails{
        @GET("recipes/{id}/information")
        Call<RecipeDetailsResponse> callRecipeDetails(
                @Path ("id") int id,
                @Query ("apiKey") String apiKey
        );
    }
}
