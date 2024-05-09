package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Model.NoteModel

class NoteAdapter(var  notes: List<NoteModel>, var listener: NoteListener) :RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    interface  NoteListener{
        fun onItemClicked(position: Int)
    }


    class NoteViewHolder(view: View): RecyclerView.ViewHolder(view){
    val noteTitleTextView: TextView = view.findViewById(R.id.title_text_view)
        val noteDescriptionTextView: TextView = view.findViewById(R.id.description_text_view)
        val deleteNoteButton: ImageButton = view.findViewById(R.id.delete_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val context=parent.context
        val view= LayoutInflater.from(context).inflate(R.layout.item_note,parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int = notes.size


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note= notes[position]
        holder.noteTitleTextView.text=note.title
        holder.noteDescriptionTextView.text=note.description
        holder.itemView.setOnClickListener{
            listener.onItemClicked(position)
        }

    }
}