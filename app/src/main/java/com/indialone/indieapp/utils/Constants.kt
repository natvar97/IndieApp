package com.indialone.indieapp.utils

import android.icu.util.Calendar
import java.text.SimpleDateFormat
import java.util.*

object Constants {

    const val DATABASE_NAME = "indieapp_database"
    const val DATABASE_TABLE_NAME = "notes_table"

    const val COL_TITLE = "title"
    const val COL_DESCRIPTION = "description"

    const val NOTE_DATABASE_VERSION = 1
    const val NOTE_EXTRA = "note"

    // news api
    const val NEWS_BASE_URL = "https://newsapi.org/v2/"
    const val API_KEY = "f0ff90e809ef4848885fad9b2250cd17"

    const val ENDPOINT_HEADLINES = "top-headlines"
    const val ENDPOINT_EVERYTHING = "everything"

    const val QUERY_STRING_COUNTRY = "country"
    const val QUERY_STRING_CATEGORY = "category"
    const val QUERY_STRING_API_KEY = "apiKey"
    const val QUERY_STRING_Q = "q"
    const val QUERY_STRING_FROM = "from"
    const val QUERY_STRING_TO = "to"
    const val QUERY_STRING_SORT_BY = "sortBy"
    const val QUERY_STRING_SOURCES = "sources"
    const val QUERY_STRING_DOMAINS = "domains"

    const val DOMAINS = "wsj.com"
    const val TECH_CRUNCH = "techcrunch"

    const val COUNTRY = "in"
    const val CATEGORY = "business"
    const val Q = "tesla"
    const val PUBLISHED_AT = "publishedAt"

    const val Q_APPLE = "apple"
    const val SORT_BY_APPLE = "popularity"

    const val EXTRA_LINK = "extralink"

    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    val date = dateFormat.format(calendar.time)
    var FROM = date

    // dishes
    const val BASE_URL_FORKIFY = "https://forkify-api.herokuapp.com/api/"
    const val SEARCH_END_POINT = "search"
    const val GET_END_POINT = "get"

    const val FILTER_SELECTION = "Filter Selection"
    const val TITLE_DIALOG = "Select Filter Option"

    const val EXTRA_DISH_ID = "dishId"

}