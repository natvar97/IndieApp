package com.indialone.indieapp.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.indialone.indieapp.R
import com.indialone.indieapp.activities.AddNoteActivity
import com.indialone.indieapp.adapters.NotesRvAdapter
import com.indialone.indieapp.databinding.FragmentNotesBinding
import com.indialone.indieapp.notes.models.NoteEntity
import com.indialone.indieapp.viewmodels.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NotesFragment : Fragment() {

    private lateinit var mBinding: FragmentNotesBinding

    @Inject
    lateinit var mNoteViewModel: NotesViewModel

    private var notes = ArrayList<NoteEntity>()


    @Inject
    lateinit var notesAdapter: NotesRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentNotesBinding.inflate(inflater, container, false)
        return mBinding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_add_note, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add_note -> {
                startActivity(Intent(mBinding.root.context, AddNoteActivity::class.java))
            }
        }
        return true
    }

    private fun getNotes() {
        mNoteViewModel.getAllNotes().observe(viewLifecycleOwner) { notesList ->
            notesAdapter.addData(notesList)
        }

        val layoutManager = GridLayoutManager(mBinding.root.context, 2)
        mBinding.rvNotes.layoutManager = layoutManager

        mBinding.rvNotes.adapter = notesAdapter
    }

    override fun onResume() {
        super.onResume()
        getNotes()
    }

    fun deleteNote(note: NoteEntity) {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Delete Note")
        builder.setMessage("Are you sure you want to delete this Note?")
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setPositiveButton("Yes") { dialogInterface, _ ->
            mNoteViewModel.deleteNote(note)
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("No") { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        val alertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

}