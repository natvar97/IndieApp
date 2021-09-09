package com.indialone.indieapp

import android.app.Application
import com.indialone.indieapp.notes.database.NoteDatabase
import com.indialone.indieapp.repositories.NotesRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class IndieApplication: Application() {


}