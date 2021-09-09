package com.indialone.indieapp.notes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.indialone.indieapp.notes.models.NoteEntity
import com.indialone.indieapp.utils.Constants

@Database(entities = [NoteEntity::class], version = Constants.NOTE_DATABASE_VERSION)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

}

/*

    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    NoteDatabase::class.java,
                    Constants.DATABASE_NAME
                ).build()
            }
            return INSTANCE!!
        }

    }
 */