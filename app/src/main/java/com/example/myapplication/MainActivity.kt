package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Model.NoteModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(),NoteAdapter.NoteListener {
    //crée la variable pour recuperer le boutton
    lateinit var  addNewNoteButton: FloatingActionButton

    lateinit var  noteRecyclerView: RecyclerView

    var notes= mutableListOf<NoteModel>(
        NoteModel("title0","description0"),
        NoteModel("title1","description1"),
        NoteModel("title2","description2")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initNoteRecyclerView()
        // lui donnée l'id  du button
        addNewNoteButton= findViewById(R.id.add_new_note_button)

        // lui mettre un evenement click et lui faire afficher un message
        addNewNoteButton.setOnClickListener{
            Log.d("MainActivity","clicked")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun initNoteRecyclerView(){
        noteRecyclerView=findViewById(R.id.note_recycler_view)
        val adapter = NoteAdapter(notes, this )
        val  layoutManager= LinearLayoutManager(this)

        noteRecyclerView.adapter=adapter
        noteRecyclerView.layoutManager= layoutManager
    }

    override fun onItemClicked(position: Int) {
       Log.d("MainActivity", "le titre est ${notes[position].title}")
    }
}

