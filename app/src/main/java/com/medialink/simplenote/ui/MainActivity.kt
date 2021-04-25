package com.medialink.simplenote.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.medialink.simplenote.R
import com.medialink.simplenote.app.showToast
import com.medialink.simplenote.model.InternalFileRepository
import com.medialink.simplenote.model.NoteRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val repo: NoteRepository by lazy { InternalFileRepository(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWrite.setOnClickListener {

        }

        btnRead.setOnClickListener {
            if (edtFileName.text.isNotEmpty()) {
                try {
                    val note = repo.getNote(edtFileName.text.toString())
                    edtNoteText.setText(note.noteText)
                } catch (e: Exception) {
                    showToast("File Read Failed")
                }
            } else {
                showToast("Please provide a Filename")
            }
        }

        btnDelete.setOnClickListener {
            if (edtFileName.text.isNotEmpty()) {
                try {
                    if (repo.delete(edtFileName.text.toString())) {
                        showToast("File Deleted")
                    } else {
                        showToast("File Could Not Be Deleted")
                    }
                } catch (e: Exception) {
                    showToast("File Delete Failed")
                }

                edtNoteText.text.clear()
                edtFileName.text.clear()

            } else {
                showToast("Please provide a Filename")
            }
        }

    }
}