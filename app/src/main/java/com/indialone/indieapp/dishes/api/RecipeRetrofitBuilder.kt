package com.indialone.indieapp.dishes.api

import com.indialone.indieapp.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RecipeRetrofitBuilder {

    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_FORKIFY)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val recipeApiService = getInstance().create(RecipeApiService::class.java)

}