package com.romero.withk.fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.romero.withk.databinding.NoteRowBinding
import com.romero.withk.model.Note

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var noteList = emptyList<Note>()

    // R.layout.note_row - NoteRowBinding
    class NoteViewHolder(val binding: NoteRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        holder.binding.apply {

            note.text = noteList[position].title

        }

    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun setNotes(notes: List<Note>) {
        noteList = notes
        notifyDataSetChanged()
    }

}