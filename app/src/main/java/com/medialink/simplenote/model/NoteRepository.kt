package com.medialink.simplenote.model

interface NoteRepository {
    fun addNote(note: Note)
    fun getNote(fileName: String): Note
    fun delete(fileName: String): Boolean
}