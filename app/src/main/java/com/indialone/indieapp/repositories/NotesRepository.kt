package com.indialone.indieapp.repositories

import androidx.annotation.WorkerThread
import com.indialone.indieapp.notes.database.NoteDao
import com.indialone.indieapp.notes.models.NoteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NotesRepository @Inject constructor(
    private val noteDao : NoteDao
) {

    @WorkerThread
    suspend fun addNote(note: NoteEntity) = noteDao.addNote(note)

    @WorkerThread
    suspend fun updateNote(note: NoteEntity) = noteDao.updateNote(note)

    @WorkerThread
    suspend fun deleteNote(note: NoteEntity) = noteDao.deleteNote(note)

    fun getAllNotes() : Flow<List<NoteEntity>> {
        return noteDao.getNotes()
    }


}