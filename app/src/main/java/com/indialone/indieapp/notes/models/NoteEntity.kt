package com.indialone.indieapp.notes.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.indialone.indieapp.utils.Constants
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = Constants.DATABASE_TABLE_NAME)
data class NoteEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = Constants.COL_TITLE)
    var title: String = "",

    @ColumnInfo(name = Constants.COL_DESCRIPTION)
    var description: String = ""

): Parcelable
