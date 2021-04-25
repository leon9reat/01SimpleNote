package com.medialink.simplenote.model

import android.content.Context
import android.os.Environment
import java.io.File

class ExternalFileRepository(var context: Context): NoteRepository {
    override fun addNote(note: Note) {
        TODO("Not yet implemented")
    }

    override fun getNote(fileName: String): Note {
        TODO("Not yet implemented")
    }

    override fun delete(fileName: String): Boolean {
        TODO("Not yet implemented")
    }

    private fun noteDirectory(): File? = context.getExternalFilesDir(null)

    private fun noteFile(fileName: String): File = File(noteDirectory(), fileName)

    fun isExternalStorageWritable(): Boolean {
        return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
    }

    fun isExternalStorageReadable(): Boolean {
        return Environment.getExternalStorageState() in
                setOf(Environment.MEDIA_MOUNTED, Environment.MEDIA_MOUNTED_READ_ONLY)
    }
}