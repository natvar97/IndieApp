package com.indialone.indieapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.indialone.indieapp.notes.models.NoteEntity
import com.indialone.indieapp.repositories.NotesRepository
import kotlinx.coroutines.launch

class NotesViewModel(
    private val notesRepository: NotesRepository
) : ViewModel() {

    fun addNote(note: NoteEntity) = viewModelScope.launch {
        notesRepository.addNote(note)
    }

    fun updateNote(note: NoteEntity) = viewModelScope.launch {
        notesRepository.updateNote(note)
    }

    fun deleteNote(note: NoteEntity) = viewModelScope.launch {
        notesRepository.deleteNote(note)
    }

    fun getAllNotes(): LiveData<List<NoteEntity>> = notesRepository.getAllNotes().asLiveData()


}