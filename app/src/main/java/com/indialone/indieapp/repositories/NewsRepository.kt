package com.indialone.indieapp.repositories

import androidx.annotation.WorkerThread
import com.indialone.indieapp.news.api.NewsRetrofitBuilder
import com.indialone.indieapp.utils.Constants

class NewsRepository {

    @WorkerThread
    suspend fun getEveryThingDomains() = NewsRetrofitBuilder
        .apiService
        .getEveryThingDomains(
            Constants.DOMAINS,
            Constants.API_KEY
        )


    @WorkerThread
    suspend fun getTopHeadlinesTechCrunch() = NewsRetrofitBuilder
        .apiService
        .getTopHeadlinesTechCrunch(
            Constants.TECH_CRUNCH,
            Constants.API_KEY
        )


    @WorkerThread
    suspend fun getTopHeadlinesCountry() = NewsRetrofitBuilder
        .apiService
        .getTopHeadlinesCountry(
            Constants.COUNTRY,
            Constants.CATEGORY,
            Constants.API_KEY
        )

    @WorkerThread
    suspend fun getEveryThingTesla() = NewsRetrofitBuilder
        .apiService
        .getEveryThingTesla(
            Constants.Q,
            Constants.FROM,
            Constants.PUBLISHED_AT,
            Constants.API_KEY
        )

    @WorkerThread
    suspend fun getEveryThingApple() = NewsRetrofitBuilder
        .apiService
        .getEveryThingApple(
            Constants.Q_APPLE,
            Constants.FROM,
            Constants.FROM,
            Constants.SORT_BY_APPLE,
            Constants.API_KEY
        )

}