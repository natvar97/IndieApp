package com.indialone.indieapp.dishes.models.search

data class SearchResponse(
	val recipes: List<RecipesItem?>? = null,
	val count: Int? = null
)
