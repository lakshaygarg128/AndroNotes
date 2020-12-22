package com.example.notes

import androidx.lifecycle.LiveData

class Noterepository(private val notedao:NoteDao) {
     val  allnotes : LiveData<List<Note>> = notedao.getallnode()
    suspend fun insert (note : Note)
    {
        notedao.insert(note)
    }
    suspend fun delete (note:Note)
    {
        notedao.delete(note)
    }
}