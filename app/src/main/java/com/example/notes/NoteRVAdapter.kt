package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdapter(private val context : Context, private val listener : INotesRVAdapter) :RecyclerView.Adapter<NoteRVAdapter.NoteViewHolder>() {
    private val allnotes = ArrayList<Note>()

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textview = itemView.findViewById<TextView>(R.id.text)
        val delte_button = itemView.findViewById<ImageButton>(R.id.image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder =
            NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note, parent, false))
        viewHolder.delte_button.setOnClickListener {
            listener.onItemClicked(allnotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentnote = allnotes[position]
        holder.textview.text = currentnote.text
    }

    override fun getItemCount(): Int {
        return allnotes.size
    }

    interface INotesRVAdapter {


        fun onItemClicked(note: Note)
    }
    fun updatelist (newlist :List<Note>){
        allnotes.clear()
        allnotes.addAll(newlist)
        notifyDataSetChanged()
    }
}