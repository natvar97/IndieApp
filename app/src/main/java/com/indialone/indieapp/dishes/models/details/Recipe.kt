package com.indialone.indieapp.dishes.models.details

data class Recipe(
    val social_rank: String? = null,
    val recipe_id: String? = null,
    val publisher_url: String? = null,
    val image_url: String? = null,
    val publisher: String? = null,
    val ingredients: List<String?>? = null,
    val title: String? = null,
    val source_url: String? = null
)
