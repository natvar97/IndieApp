package com.indialone.indieapp.di

import android.content.Context
import androidx.room.Room
import com.indialone.indieapp.notes.database.NoteDao
import com.indialone.indieapp.notes.database.NoteDatabase
import com.indialone.indieapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideDao(database: NoteDatabase): NoteDao {
        return database.noteDao()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            Constants.DATABASE_NAME
        ).build()
    }


}