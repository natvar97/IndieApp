package com.indialone.indieapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.indialone.indieapp.repositories.NewsRepository
import com.indialone.indieapp.repositories.NotesRepository
import com.indialone.indieapp.repositories.DishesRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private val notesRepository: NotesRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotesViewModel::class.java)) {
            return NotesViewModel(notesRepository) as T
        }
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(NewsRepository()) as T
        }
        if (modelClass.isAssignableFrom(DishesViewModel::class.java)) {
            return DishesViewModel(DishesRepository()) as T
        }
        throw IllegalArgumentException("Unknown View Model class found")
    }
}