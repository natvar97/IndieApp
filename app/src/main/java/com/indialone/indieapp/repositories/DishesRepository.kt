package com.indialone.indieapp.repositories

import androidx.annotation.WorkerThread
import com.indialone.indieapp.dishes.api.RecipeRetrofitBuilder

class DishesRepository {

    @WorkerThread
    suspend fun getRecipes(query: String) = RecipeRetrofitBuilder
        .recipeApiService
        .getRecipes(query)


    @WorkerThread
    suspend fun getRecipesDetails(rId: String) = RecipeRetrofitBuilder
        .recipeApiService
        .getRecipeDetails(rId)


}