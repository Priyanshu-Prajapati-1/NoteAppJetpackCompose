package com.example.noteappcompose.data

import androidx.compose.runtime.MutableState
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.noteappcompose.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDAO {

    @Query("SELECT * FROM notes_table")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM notes_table where id =:id")
    suspend fun getNotesById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: Note)

    @Query("Delete from notes_table")
    suspend fun deleteAll()

    @Delete()
    suspend fun deleteNote(note: Note)
}