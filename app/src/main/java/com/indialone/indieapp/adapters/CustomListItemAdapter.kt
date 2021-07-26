package com.indialone.indieapp.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.indialone.indieapp.databinding.ItemCustomListLayoutBinding
import com.indialone.indieapp.fragments.DishesFragment

class CustomListItemAdapter(
    private val activity: Activity,
    private val fragment: Fragment,
    private val list: ArrayList<String>,
    private val selection: String
) : RecyclerView.Adapter<CustomListItemAdapter.CustomListItemViewHolder>() {
    class CustomListItemViewHolder(itemView: ItemCustomListLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        val tvTitle = itemView.tvText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomListItemViewHolder {
        val view =
            ItemCustomListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomListItemViewHolder, position: Int) {
        holder.tvTitle.text = list[position]
        holder.itemView.setOnClickListener {
            if (fragment is DishesFragment) {
                fragment.filterSelection(list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}