package com.faz.data.local.datasource

import com.faz.data.local.dao.NewsDao
import com.faz.data.mapper.mapFromEntityToPure
import com.faz.data.mapper.mapFromPureToEntity
import com.faz.domain.model.NewsArticle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NewsLocalDataSourceImpl(private val newsDao: NewsDao) : NewsLocalDataSource {
    override fun fetchNews(page: Int): Flow<List<NewsArticle>> = newsDao.getAllNews(page).map {
        it.mapFromEntityToPure()
    }

    override suspend fun insertNews(news: List<NewsArticle>) =
        newsDao.insertNews(news.mapFromPureToEntity())
}