package com.example.noteappcompose.repository

import com.example.noteappcompose.data.NoteDatabaseDAO
import com.example.noteappcompose.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDAO: NoteDatabaseDAO) {

    suspend fun addNote(note: Note) = noteDatabaseDAO.insertNote(note = note)
    suspend fun updateNote(note: Note) = noteDatabaseDAO.updateNote(note = note)
    suspend fun deleteNote(note: Note) = noteDatabaseDAO.deleteNote(note = note)
    suspend fun deleteAllNotes() = noteDatabaseDAO.deleteAll()
    fun getAllNotes(): Flow<List<Note>> =
        noteDatabaseDAO.getNotes().flowOn(Dispatchers.IO).conflate()
    suspend fun getNoteById(id: String) =  noteDatabaseDAO.getNotesById(id = id)

}