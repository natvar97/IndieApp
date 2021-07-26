package com.indialone.indieapp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indialone.indieapp.activities.DishDetailsActivity
import com.indialone.indieapp.databinding.DishItemLayoutBinding
import com.indialone.indieapp.dishes.models.search.RecipesItem
import com.indialone.indieapp.utils.Constants

class DishesRvAdapter(
    private var dishes: ArrayList<RecipesItem>
) : RecyclerView.Adapter<DishesRvAdapter.DishesRvViewHolder>() {
    class DishesRvViewHolder(itemView: DishItemLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        private val tvTitle = itemView.tvTitle
        private val tvPublisher = itemView.tvPublisher
        private val ivDish = itemView.ivDish
        val ivNext = itemView.ivNext

        fun bind(dish: RecipesItem) {
            tvTitle.text = dish.title
            tvPublisher.text = dish.publisher
            Glide.with(itemView.context)
                .load(dish.image_url)
                .centerCrop()
                .into(ivDish)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishesRvViewHolder {
        val view = DishItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DishesRvViewHolder(view)
    }

    override fun onBindViewHolder(holder: DishesRvViewHolder, position: Int) {
        holder.bind(dish = dishes[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DishDetailsActivity::class.java)
            intent.putExtra(Constants.EXTRA_DISH_ID, dishes[position].recipe_id)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dishes.size
    }
}