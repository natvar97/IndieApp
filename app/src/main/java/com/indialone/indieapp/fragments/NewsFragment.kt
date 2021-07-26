package com.indialone.indieapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.indialone.indieapp.IndieApplication
import com.indialone.indieapp.adapters.NewsRvAdapter
import com.indialone.indieapp.databinding.FragmentNewsBinding
import com.indialone.indieapp.news.models.ArticlesItem
import com.indialone.indieapp.viewmodels.NewsViewModel
import com.indialone.indieapp.viewmodels.ViewModelFactory
import java.util.ArrayList

class NewsFragment : Fragment() {

    private lateinit var mBinding: FragmentNewsBinding
    private var news = ArrayList<ArticlesItem>()
    private lateinit var newsRvAdapter: NewsRvAdapter
    private val mNewsViewModel: NewsViewModel by viewModels {
        ViewModelFactory((requireActivity().application as IndieApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentNewsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    private fun getNews() {

        mNewsViewModel.getTopHeadlinesCountry().observe(viewLifecycleOwner) { newsEntity ->
            news.addAll(newsEntity.articles as ArrayList<ArticlesItem>)
            createRecyclerView(news)
        }

        mNewsViewModel.getTopHeadlinesTechCrunch().observe(viewLifecycleOwner) { newsEntity ->
            news.addAll(newsEntity.articles as ArrayList<ArticlesItem>)
            createRecyclerView(news)
        }

        mNewsViewModel.getEveryThingApple().observe(viewLifecycleOwner) { newsEntity ->
            news.addAll(newsEntity.articles as ArrayList<ArticlesItem>)
            createRecyclerView(news)
        }

        mNewsViewModel.getEveryThingTesla().observe(viewLifecycleOwner) { newsEntity ->
            news.addAll(newsEntity.articles as ArrayList<ArticlesItem>)
            createRecyclerView(news)
        }

        mNewsViewModel.getEverythingDomains().observe(viewLifecycleOwner) { newsEntity ->
            news.addAll(newsEntity.articles as ArrayList<ArticlesItem>)
            createRecyclerView(news)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.swipeToRefresh.setOnRefreshListener {
            if (mBinding.swipeToRefresh.isRefreshing) {
                mNewsViewModel.fetchTopHeadlinesCountry()
                mNewsViewModel.fetchTopHeadlinesTechCrunch()
                mNewsViewModel.fetchEveryThingApple()
                mNewsViewModel.fetchEveryThingTesla()
                mNewsViewModel.fetchEverythingDomains()
                mBinding.swipeToRefresh.isRefreshing = false
            }
        }
    }

    private fun createRecyclerView(news: ArrayList<ArticlesItem>) {
        mBinding.rvNews.layoutManager = LinearLayoutManager(requireActivity())
        newsRvAdapter = NewsRvAdapter(news)
        mBinding.rvNews.adapter = newsRvAdapter
    }

    override fun onResume() {
        super.onResume()
        news.clear()
        getNews()
    }

}