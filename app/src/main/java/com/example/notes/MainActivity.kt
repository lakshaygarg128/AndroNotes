package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , NoteRVAdapter.INotesRVAdapter{
    lateinit var viewmodel:NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview.layoutManager= LinearLayoutManager(this)
        val adapter = NoteRVAdapter(this,this)
        recyclerview.adapter=adapter
        viewmodel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
            viewmodel.allnote.observe(this, Observer {list ->
                list?.let {
                    adapter.updatelist(it)
                }

            })


    }
    override fun onItemClicked (note :Note)
    {
   viewmodel.deleteNote(note)
    }

    fun submitdata(view: View) {
        val notetext = input.text.toString()
        if(notetext.isNotEmpty())
        {
            viewmodel.insertnote(Note(notetext))
        }
    }
}