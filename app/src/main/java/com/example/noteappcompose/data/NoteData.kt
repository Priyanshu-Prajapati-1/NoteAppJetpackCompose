package com.example.noteappcompose.data

import com.example.noteappcompose.model.Note

class NotesDataSource(){
    fun loadNotes() : List<Note> {
        return listOf(
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "A good day", description = "We went on a vacation"),
            Note(title = "A good day", description = "We went on a vacation"),
        )
    }
}