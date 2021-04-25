package com.medialink.simplenote.model

import android.content.Context
import android.os.Environment
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class EncryptedFileRepository(var context: Context): NoteRepository {
    private val passwordString = "Swordfish"

    override fun addNote(note: Note) {
        TODO("Not yet implemented")
    }

    override fun getNote(fileName: String): Note {
        TODO("Not yet implemented")
    }

    override fun delete(fileName: String): Boolean {
        TODO("Not yet implemented")
    }

    private fun decrypt(map: HashMap<String, ByteArray>): ByteArray? {
        var decrypted: ByteArray? = null
        return decrypted
    }

    private fun encrypt(plainTextBytes: ByteArray): HashMap<String, ByteArray> {
        val map = HashMap<String, ByteArray>()
        return map
    }

    private fun noteDirectory(): File? = context.getExternalFilesDir(null)

    private fun noteFile(fileName: String): File = File(noteDirectory(), fileName)

    private fun noteFileOutputStream(fileName: String): FileOutputStream = FileOutputStream(noteFile(fileName))

    private fun noteFileInputStream(fileName: String): FileInputStream = FileInputStream(noteFile(fileName))

    fun isExternalStorageWritable(): Boolean {
        return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
    }

    fun isExternalStorageReadable(): Boolean {
        return Environment.getExternalStorageState() in
                setOf(Environment.MEDIA_MOUNTED, Environment.MEDIA_MOUNTED_READ_ONLY)
    }
}