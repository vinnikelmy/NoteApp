package com.example.noteapp.feature_note.data.repository

import com.example.noteapp.feature_note.data.local.NoteDao
import com.example.noteapp.feature_note.data.mappers.toNote
import com.example.noteapp.feature_note.data.mappers.toNoteEntity
import com.example.noteapp.feature_note.domain.model.Note
import com.example.noteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepositoryImpl @Inject constructor(
    private val dao: NoteDao
): NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes().map { it ->
            it.map {
                it.toNote()
            }
        }
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)?.toNote()
    }

    override suspend fun upsertNote(note: Note) {
        return dao.upsertNoteList(note.toNoteEntity())
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note.toNoteEntity())
    }
}