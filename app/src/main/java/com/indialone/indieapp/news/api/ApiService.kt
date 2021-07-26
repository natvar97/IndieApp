package com.indialone.indieapp.news.api

import com.indialone.indieapp.news.models.NewsEntity
import com.indialone.indieapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.CompletionStage

interface ApiService {

    @GET(Constants.ENDPOINT_EVERYTHING)
    suspend fun getEveryThingDomains(
        @Query(Constants.QUERY_STRING_DOMAINS) domains: String,
        @Query(Constants.QUERY_STRING_API_KEY) apiKey: String
    ): NewsEntity

    @GET(Constants.ENDPOINT_HEADLINES)
    suspend fun getTopHeadlinesTechCrunch(
        @Query(Constants.QUERY_STRING_SOURCES) sources: String,
        @Query(Constants.QUERY_STRING_API_KEY) apiKey: String
    ): NewsEntity

    @GET(Constants.ENDPOINT_HEADLINES)
    suspend fun getTopHeadlinesCountry(
        @Query(Constants.QUERY_STRING_COUNTRY) country: String,
        @Query(Constants.QUERY_STRING_CATEGORY) category: String,
        @Query(Constants.QUERY_STRING_API_KEY) apiKey: String
    ): NewsEntity

    @GET(Constants.ENDPOINT_EVERYTHING)
    suspend fun getEveryThingTesla(
        @Query(Constants.QUERY_STRING_Q) q: String,
        @Query(Constants.QUERY_STRING_FROM) from: String,
        @Query(Constants.QUERY_STRING_SORT_BY) sortBy: String,
        @Query(Constants.QUERY_STRING_API_KEY) apiKey: String
    ): NewsEntity


    @GET(Constants.ENDPOINT_EVERYTHING)
    suspend fun getEveryThingApple(
        @Query(Constants.QUERY_STRING_Q) q: String,
        @Query(Constants.QUERY_STRING_FROM) from: String,
        @Query(Constants.QUERY_STRING_TO) to: String,
        @Query(Constants.QUERY_STRING_SORT_BY) sortBy: String,
        @Query(Constants.QUERY_STRING_API_KEY) apiKey: String
    ): NewsEntity


}