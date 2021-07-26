package com.indialone.indieapp

import android.app.Application
import com.indialone.indieapp.notes.database.NoteDatabase
import com.indialone.indieapp.repositories.NotesRepository

class IndieApplication: Application() {

    private val database by lazy {
        NoteDatabase.getInstance(this)
    }

    val repository by lazy {
        NotesRepository(database.noteDao())
    }

}