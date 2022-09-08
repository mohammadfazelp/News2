package com.faz.data.local.datasource

import com.faz.domain.model.NewsArticle
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {
    fun fetchNews(page: Int): Flow<List<NewsArticle>>
    suspend fun insertNews(news: List<NewsArticle>)
}