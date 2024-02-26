package com.example.noteapp.feature_note.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM noteentity")
    fun getNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM noteentity WHERE id = :id")
    suspend fun getNoteById(id: Int): NoteEntity?

    @Upsert
    suspend fun upsertNoteList(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)
}