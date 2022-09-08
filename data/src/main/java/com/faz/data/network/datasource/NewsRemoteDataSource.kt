package com.faz.data.network.datasource

import com.faz.domain.model.NewsArticle
import kotlinx.coroutines.flow.Flow

interface NewsRemoteDataSource {
    fun fetchNews(page: Int): Flow<List<NewsArticle>>
}