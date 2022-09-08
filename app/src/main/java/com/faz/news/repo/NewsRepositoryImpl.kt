package com.faz.news.repo

import com.faz.news.model.NewsArticle
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl : NewsRepository {

    override fun fetchNews(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<List<NewsArticle>> {
        TODO("Not yet implemented")
    }
}