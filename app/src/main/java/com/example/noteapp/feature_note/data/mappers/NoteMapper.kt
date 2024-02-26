package com.example.noteapp.feature_note.data.mappers

import com.example.noteapp.feature_note.data.local.NoteEntity
import com.example.noteapp.feature_note.domain.model.Note

fun NoteEntity.toNote(): Note {
    return Note(
        title = title,
        content = content,
        timestamp = timestamp,
        color = color,
        id = id
    )
}

fun Note.toNoteEntity(): NoteEntity {
    return NoteEntity(
        title = title,
        content = content,
        timestamp = timestamp,
        color = color,
        id = id
    )
}