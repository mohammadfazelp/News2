package com.faz.data.repo

import com.faz.data.local.datasource.NewsLocalDataSource
import com.faz.data.network.datasource.NewsRemoteDataSource
import com.faz.data.network.dispatcher.Dispatcher
import com.faz.data.network.dispatcher.NewsDispatchers
import com.faz.domain.model.NewsArticle
import com.faz.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onEmpty
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource,
    @Dispatcher(NewsDispatchers.IO) private val ioDispatcher: Dispatcher
) : NewsRepository {

    override fun fetchNews(page: Int): Flow<List<NewsArticle>> {
        val news = newsLocalDataSource.fetchNews(page)
        news.onEmpty {
            newsRemoteDataSource.fetchNews(page).onEach {
                newsLocalDataSource.insertNews(it)
            }
        }
        return newsLocalDataSource.fetchNews(page)
    }

    override fun saveNews(news: List<NewsArticle>) {
        newsLocalDataSource.insertNews(news)
    }
}