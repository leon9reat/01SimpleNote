package com.medialink.simplenote.model

import android.content.Context
import java.io.File

class InternalFileRepository(var context: Context): NoteRepository {
    override fun addNote(note: Note) {
        TODO("Not yet implemented")
    }

    override fun getNote(fileName: String): Note {
        TODO("Not yet implemented")
    }

    override fun delete(fileName: String): Boolean {
        TODO("Not yet implemented")
    }

    private fun noteFile(fileName: String): File = File(noteDirectory(), fileName)

    private fun noteDirectory(): String {
        return context.filesDir.absolutePath
    }
}