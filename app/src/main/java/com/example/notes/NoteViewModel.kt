package com.example.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel (application :Application ): AndroidViewModel(Application()) {
    val noterepo : Noterepository
    val allnote :LiveData<List<Note>>
    init {
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        noterepo = Noterepository(dao)
        allnote= noterepo.allnotes
    }
    fun deleteNote(note :Note) = viewModelScope.launch(Dispatchers.IO) {
    noterepo.delete(note)
    }
    fun insertnote(note :Note) = viewModelScope.launch (Dispatchers.IO){
    noterepo.insert(note)
    }
}