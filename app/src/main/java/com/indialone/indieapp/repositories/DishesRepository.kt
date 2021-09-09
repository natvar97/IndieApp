package com.indialone.indieapp.repositories

import androidx.annotation.WorkerThread
import com.indialone.indieapp.dishes.api.RecipeApiService
import com.indialone.indieapp.dishes.api.RecipeRetrofitBuilder
import javax.inject.Inject

class DishesRepository @Inject constructor(private val recipeApiService: RecipeApiService) {

    @WorkerThread
    suspend fun getRecipes(query: String) = recipeApiService.getRecipes(query)


    @WorkerThread
    suspend fun getRecipesDetails(rId: String) = recipeApiService.getRecipeDetails(rId)


}