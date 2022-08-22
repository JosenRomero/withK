package com.romero.withk.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.romero.withk.data.NoteDatabase
import com.romero.withk.model.Note
import com.romero.withk.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// A ViewModel acts as a communication center between the Repository and the UI

class NoteViewModel(application: Application): AndroidViewModel(application) {

    val readAllNotes: LiveData<List<Note>>
    private val repository: NoteRepository

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        readAllNotes = repository.readAllNotes
    }

    fun addNote(note: Note) {

        viewModelScope.launch(Dispatchers.IO) {
            repository.addNote(note)
        }
    }

    fun updateNote(note: Note) {

        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNote(note)
        }

    }

    fun deleteNote(note: Note) {

        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(note)
        }

    }

}