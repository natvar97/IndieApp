package com.indialone.indieapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indialone.indieapp.dishes.models.details.RecipeDetailsResponse
import com.indialone.indieapp.dishes.models.search.SearchResponse
import com.indialone.indieapp.repositories.DishesRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class DishesViewModel(
    private val dishesRepository: DishesRepository
) : ViewModel() {

    private val recipes = MutableLiveData<SearchResponse>()
    private val recipeDetails = MutableLiveData<RecipeDetailsResponse>()

    init {
        fetchRecipes("")
        fetchRecipesDetails("")
    }

    fun fetchRecipesDetails(rId: String) {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val recipe = async {
                        dishesRepository.getRecipesDetails(rId)
                    }
                    recipeDetails.postValue(recipe.await())
                }
            } catch (e: Exception) {
            }

        }
    }

    fun fetchRecipes(selection: String) {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val recipesList = async {
                        dishesRepository.getRecipes(selection)
                    }
                    recipes.postValue(recipesList.await())
                }
            } catch (e: Exception) {
            }

        }
    }

    fun getRecipes(): LiveData<SearchResponse> = recipes
    fun getRecipeDetails(): LiveData<RecipeDetailsResponse> = recipeDetails


}