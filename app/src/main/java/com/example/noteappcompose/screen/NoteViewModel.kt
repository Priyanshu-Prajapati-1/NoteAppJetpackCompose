package com.example.noteappcompose.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappcompose.data.NotesDataSource
import com.example.noteappcompose.model.Note
import com.example.noteappcompose.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()
    // private var noteList = mutableStateListOf<Note>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged().collect{listOfNotes->
                if(listOfNotes.isEmpty()){
                    Log.d("Empty", ": Empty Note")
                }else{
                    _noteList.value = listOfNotes
                }
            }
        }
    }

    fun addNote(note: Note)  = viewModelScope.launch { repository.addNote(note = note) }
    fun removeNote(note: Note) = viewModelScope.launch { repository.deleteNote(note = note) }
    fun updateNote(note: Note) = viewModelScope.launch {repository.updateNote(note = note) }


//    private var noteList = mutableStateListOf<Note>()
//
//    init {
//        noteList.addAll(NotesDataSource().loadNotes())
//    }
//
//    fun addNote(note: Note) {
//        noteList.add(note)
//    }
//
//    fun removeNote(note: Note) {
//        noteList.remove(note)
//    }
//
//    fun getAllNotes() : List<Note> {
//        return noteList
//    }
}