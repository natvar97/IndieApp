package com.indialone.indieapp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indialone.indieapp.activities.WebViewActivity
import com.indialone.indieapp.databinding.NewsItemLayoutBinding
import com.indialone.indieapp.news.models.ArticlesItem
import com.indialone.indieapp.utils.Constants
import javax.inject.Inject

class NewsRvAdapter @Inject constructor() : RecyclerView.Adapter<NewsRvAdapter.NewsRvViewHolder>() {

    private val news = ArrayList<ArticlesItem>()

    class NewsRvViewHolder(itemView: NewsItemLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        private val ivNews = itemView.ivImage
        private val tvTitle = itemView.tvTitle
        private val tvAuthor = itemView.tvAuthor
        private val tvPublishedAt = itemView.tvPublishedAt

        fun bind(article: ArticlesItem) {
            tvTitle.text = article.title
            tvAuthor.text = article.author
            tvPublishedAt.text = article.publishedAt
            Glide.with(itemView.context)
                .load(article.urlToImage)
                .centerCrop()
                .into(ivNews)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsRvViewHolder {
        val view = NewsItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsRvViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsRvViewHolder, position: Int) {
        holder.bind(news[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, WebViewActivity::class.java)
            intent.putExtra(Constants.EXTRA_LINK, news[position].url)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return news.size
    }

    fun addData(list: List<ArticlesItem>) {
        news.clear()
        news.addAll(list)
        notifyDataSetChanged()
    }

}