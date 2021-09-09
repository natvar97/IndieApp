package com.indialone.indieapp.dishes.api

import com.indialone.indieapp.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeRetrofitBuilder {

    companion object {
        private var instace: RecipeRetrofitBuilder? = null

        fun getInstance() : RecipeRetrofitBuilder {
            if (instace == null) {
                instace = RecipeRetrofitBuilder()
            }
            return instace!!
        }

    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_FORKIFY)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}