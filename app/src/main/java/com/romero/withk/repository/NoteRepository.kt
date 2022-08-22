package com.romero.withk.repository

import androidx.lifecycle.LiveData
import com.romero.withk.data.NoteDao
import com.romero.withk.model.Note

// A repository class access to multiple data sources

class NoteRepository(private val noteDao: NoteDao) {

    val readAllNotes: LiveData<List<Note>> = noteDao.readAllNotes()

    suspend fun addNote(note: Note) {

        noteDao.addNote(note)

    }

    suspend fun updateNote(note: Note) {

        noteDao.updateNote(note)

    }

    suspend fun deleteNote(note: Note) {

        noteDao.deleteNote(note)

    }

}