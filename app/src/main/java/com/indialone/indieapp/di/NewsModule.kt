package com.indialone.indieapp.di

import com.indialone.indieapp.news.api.NewsApiService
import com.indialone.indieapp.news.api.NewsRetrofitBuilder
import com.indialone.indieapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NewsModule {

    @Provides
    fun provideNewsApiService(retrofit: NewsRetrofitBuilder): NewsApiService {
        return retrofit.getRetrofit().create(NewsApiService::class.java)
    }

    @Provides
    fun provideNewsRetrofit(): NewsRetrofitBuilder {
        return NewsRetrofitBuilder.getInstance()
    }


}