package com.indialone.indieapp.dishes.api

import com.indialone.indieapp.dishes.models.details.RecipeDetailsResponse
import com.indialone.indieapp.dishes.models.search.SearchResponse
import com.indialone.indieapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApiService {

    @GET(Constants.SEARCH_END_POINT)
    suspend fun getRecipes(
        @Query("q") q: String
    ) : SearchResponse

    @GET(Constants.GET_END_POINT)
    suspend fun getRecipeDetails(
        @Query("rId") rId: String
    ): RecipeDetailsResponse

}