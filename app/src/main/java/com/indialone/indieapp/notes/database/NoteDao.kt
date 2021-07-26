package com.indialone.indieapp.notes.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.indialone.indieapp.notes.models.NoteEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {

    @Query("SELECT * FROM notes_table")
    fun getNotes() : Flow<List<NoteEntity>>

    @Insert
    suspend fun addNote(note: NoteEntity)

    @Update
    suspend fun updateNote(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)

}