package com.indialone.indieapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indialone.indieapp.news.models.NewsEntity
import com.indialone.indieapp.repositories.NewsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val everythingDomains = MutableLiveData<NewsEntity>()
    private val topHeadlinesTechCrunch = MutableLiveData<NewsEntity>()
    private val topHeadlinesCountry = MutableLiveData<NewsEntity>()
    private val everyThingTesla = MutableLiveData<NewsEntity>()
    private val everyThingApple = MutableLiveData<NewsEntity>()

    init {
        fetchEverythingDomains()
        fetchTopHeadlinesTechCrunch()
        fetchTopHeadlinesCountry()
        fetchEveryThingTesla()
        fetchEveryThingApple()
    }

    fun fetchEveryThingApple() {
        viewModelScope.launch {
            coroutineScope {
                val news = async {
                    newsRepository.getEveryThingApple()
                }
                everyThingApple.postValue(news.await())
            }
        }
    }

    fun fetchEveryThingTesla() {
        viewModelScope.launch {
            coroutineScope {
                val news = async {
                    newsRepository.getEveryThingTesla()
                }
                everyThingTesla.postValue(news.await())
            }
        }
    }

    fun fetchTopHeadlinesCountry() {
        viewModelScope.launch {
            coroutineScope {
                val news = async {
                    newsRepository.getTopHeadlinesCountry()
                }
                topHeadlinesCountry.postValue(news.await())
            }
        }
    }

    fun fetchTopHeadlinesTechCrunch() {
        viewModelScope.launch {
            coroutineScope {
                val news = async {
                    newsRepository.getTopHeadlinesTechCrunch()
                }
                topHeadlinesTechCrunch.postValue(news.await())
            }
        }
    }

    fun fetchEverythingDomains() {
        viewModelScope.launch {
            coroutineScope {
                val news = async {
                    newsRepository.getEveryThingDomains()
                }
                everythingDomains.postValue(news.await())
            }
        }
    }

    fun getEverythingDomains(): LiveData<NewsEntity> = everythingDomains

    fun getTopHeadlinesTechCrunch(): LiveData<NewsEntity> = topHeadlinesTechCrunch

    fun getTopHeadlinesCountry(): LiveData<NewsEntity> = topHeadlinesCountry

    fun getEveryThingTesla(): LiveData<NewsEntity> = everyThingTesla

    fun getEveryThingApple(): LiveData<NewsEntity> = everyThingApple

}