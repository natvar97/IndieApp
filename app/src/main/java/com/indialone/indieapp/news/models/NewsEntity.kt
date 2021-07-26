package com.indialone.indieapp.news.models

data class NewsEntity(
	val totalResults: Int? = null,
	val articles: List<ArticlesItem?>? = null,
	val status: String? = null
)
