package com.indialone.indieapp.di

import com.indialone.indieapp.dishes.api.RecipeApiService
import com.indialone.indieapp.dishes.api.RecipeRetrofitBuilder
import com.indialone.indieapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RecipeModule {

    @Provides
    fun provideRecipesApiService(retrofit: RecipeRetrofitBuilder): RecipeApiService {
        return retrofit.getRetrofit().create(RecipeApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRecipeRetrofit(): RecipeRetrofitBuilder {
        return RecipeRetrofitBuilder.getInstance()
    }

}