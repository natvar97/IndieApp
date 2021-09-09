package com.indialone.indieapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.indialone.indieapp.adapters.NewsRvAdapter
import com.indialone.indieapp.databinding.FragmentNewsBinding
import com.indialone.indieapp.news.models.ArticlesItem
import com.indialone.indieapp.viewmodels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList
import javax.inject.Inject

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private lateinit var mBinding: FragmentNewsBinding
    private var news = ArrayList<ArticlesItem>()

    @Inject
    lateinit var newsRvAdapter: NewsRvAdapter

    @Inject
    lateinit var mNewsViewModel: NewsViewModel

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
            newsRvAdapter.addData(newsEntity.articles as ArrayList<ArticlesItem>)
            createRecyclerView()
        }

        mNewsViewModel.getTopHeadlinesTechCrunch().observe(viewLifecycleOwner) { newsEntity ->
            newsRvAdapter.addData(newsEntity.articles as ArrayList<ArticlesItem>)
            createRecyclerView()
        }

        mNewsViewModel.getEveryThingApple().observe(viewLifecycleOwner) { newsEntity ->
            newsRvAdapter.addData(newsEntity.articles as ArrayList<ArticlesItem>)
            createRecyclerView()
        }

        mNewsViewModel.getEveryThingTesla().observe(viewLifecycleOwner) { newsEntity ->
            newsRvAdapter.addData(newsEntity.articles as ArrayList<ArticlesItem>)
            createRecyclerView()
        }

        mNewsViewModel.getEverythingDomains().observe(viewLifecycleOwner) { newsEntity ->
            news.addAll(newsEntity.articles as ArrayList<ArticlesItem>)
            createRecyclerView()
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

    private fun createRecyclerView() {
        mBinding.rvNews.layoutManager = LinearLayoutManager(requireActivity())
        mBinding.rvNews.adapter = newsRvAdapter
    }

    override fun onResume() {
        super.onResume()
        news.clear()
        getNews()
    }

}