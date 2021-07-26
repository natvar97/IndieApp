package com.indialone.indieapp.news.api

import com.indialone.indieapp.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsRetrofitBuilder {

    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.NEWS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService = getInstance().create(ApiService::class.java)

}