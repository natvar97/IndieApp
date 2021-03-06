package com.indialone.indieapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.view.menu.MenuPopupHelper
import androidx.appcompat.widget.PopupMenu
import androidx.core.graphics.createBitmap
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.indialone.indieapp.R
import com.indialone.indieapp.activities.AddNoteActivity
import com.indialone.indieapp.databinding.NoteItemLayoutBinding
import com.indialone.indieapp.fragments.NotesFragment
import com.indialone.indieapp.notes.models.NoteEntity
import com.indialone.indieapp.utils.Constants
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NotesRvAdapter @Inject constructor(
    @ApplicationContext private val context: Context
) : RecyclerView.Adapter<NotesRvAdapter.NotesRvViewHolder>() {

    private val notes = ArrayList<NoteEntity>()
    private var fragment = Fragment()

    class NotesRvViewHolder(itemView: NoteItemLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        private val tvTitle = itemView.tvTitle
        private val tvDescription = itemView.tvDescription
        val ivMore = itemView.ivMore

        fun bind(note: NoteEntity) {
            tvTitle.text = note.title
            tvDescription.text = note.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesRvViewHolder {
        val view = NoteItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesRvViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesRvViewHolder, position: Int) {
        holder.bind(notes[position])

        holder.ivMore.setOnClickListener {
            val popMenu = PopupMenu(it.context, holder.ivMore)
            popMenu.menuInflater.inflate(R.menu.menu_more, popMenu.menu)

            popMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_edit -> {
                        val intent = Intent(context, AddNoteActivity::class.java)
                        intent.putExtra(Constants.NOTE_EXTRA, notes[position])
                        context.startActivity(intent)
                        true
                    }
                    R.id.action_delete -> {
                        when (fragment) {
                            is NotesFragment -> {
                                (fragment as NotesFragment).deleteNote(notes[position])
                            }
                        }
                        true
                    }
                    else -> {
                        true
                    }
                }
            }

            popMenu.show()

        }

    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun addData(list: List<NoteEntity>) {
        notes.clear()
        notes.addAll(list)
        notifyDataSetChanged()
    }

}