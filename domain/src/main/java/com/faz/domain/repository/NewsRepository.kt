package com.faz.domain.repository

import com.faz.domain.model.NewsArticle
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun fetchNews(page: Int): Flow<List<NewsArticle>>

    fun saveNews(news: List<NewsArticle>)
}