package com.indialone.indieapp.repositories

import androidx.annotation.WorkerThread
import com.indialone.indieapp.news.api.NewsApiService
import com.indialone.indieapp.news.api.NewsRetrofitBuilder
import com.indialone.indieapp.utils.Constants
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApiService: NewsApiService) {

    @WorkerThread
    suspend fun getEveryThingDomains() = newsApiService
        .getEveryThingDomains(
            Constants.DOMAINS,
            Constants.API_KEY
        )


    @WorkerThread
    suspend fun getTopHeadlinesTechCrunch() = newsApiService
        .getTopHeadlinesTechCrunch(
            Constants.TECH_CRUNCH,
            Constants.API_KEY
        )


    @WorkerThread
    suspend fun getTopHeadlinesCountry() = newsApiService
        .getTopHeadlinesCountry(
            Constants.COUNTRY,
            Constants.CATEGORY,
            Constants.API_KEY
        )

    @WorkerThread
    suspend fun getEveryThingTesla() = newsApiService
        .getEveryThingTesla(
            Constants.Q,
            Constants.FROM,
            Constants.PUBLISHED_AT,
            Constants.API_KEY
        )

    @WorkerThread
    suspend fun getEveryThingApple() = newsApiService
        .getEveryThingApple(
            Constants.Q_APPLE,
            Constants.FROM,
            Constants.FROM,
            Constants.SORT_BY_APPLE,
            Constants.API_KEY
        )

}