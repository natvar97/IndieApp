package com.indialone.indieapp.news.api

import com.indialone.indieapp.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRetrofitBuilder {

    companion object {
        private var instance: NewsRetrofitBuilder? = null

        fun getInstance(): NewsRetrofitBuilder {
            if (instance == null) {
                instance = NewsRetrofitBuilder()
            }
            return instance!!
        }


    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.NEWS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}