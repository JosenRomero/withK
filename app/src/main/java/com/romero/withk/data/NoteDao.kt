package com.romero.withk.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.romero.withk.model.Note

// DAO - Data Access Object

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addNote(note: Note)

    @Query("SELECT * FROM note_table ORDER BY id ASC")
    fun readAllNotes(): LiveData<List<Note>>

}