package com.indialone.indieapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.indialone.indieapp.R
import com.indialone.indieapp.databinding.ActivityAddNoteBinding
import com.indialone.indieapp.notes.models.NoteEntity
import com.indialone.indieapp.utils.Constants
import com.indialone.indieapp.viewmodels.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddNoteActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityAddNoteBinding

    @Inject
    lateinit var mNoteViewModel: NotesViewModel

    private var title: String = ""
    private var description: String = ""
    private var mNoteEdit: NoteEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setUpActionBar()

        if (intent.hasExtra(Constants.NOTE_EXTRA)) {
            mNoteEdit = intent.getParcelableExtra(Constants.NOTE_EXTRA)
        }

        if (mNoteEdit != null) {
            mBinding.etTitle.setText(mNoteEdit!!.title)
            mBinding.etDescription.setText(mNoteEdit!!.description)
            mBinding.btnSave.setText("Update")
        }

        mBinding.btnSave.setOnClickListener {
            if (validateNotesDetails()) {
                var noteId = 0

                if (mNoteEdit != null) {
                    noteId = mNoteEdit!!.id
                }

                val note = NoteEntity(id = noteId, title = title, description = description)

                if (noteId == 0) {
                    mNoteViewModel.addNote(note)
                } else {
                    mNoteViewModel.updateNote(note)
                }

                finish()
            }
        }

    }

    private fun validateNotesDetails(): Boolean {
        title = mBinding.etTitle.text.toString().trim { it <= ' ' }
        description = mBinding.etDescription.text.toString().trim { it <= ' ' }

        return when {
            TextUtils.isEmpty(title) -> {
                Toast.makeText(this, "Please Enter Title!!", Toast.LENGTH_SHORT).show()
                false
            }
            TextUtils.isEmpty(description) -> {
                Toast.makeText(this, "Please Enter description!!", Toast.LENGTH_SHORT).show()
                false
            }
            else -> {
                true
            }
        }

    }

    private fun setUpActionBar() {
        setSupportActionBar(mBinding.toolbar)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.icon_back)
        }

        mBinding.toolbar.setNavigationOnClickListener { onBackPressed() }


    }

}