package com.faz.news.repo

import androidx.annotation.WorkerThread
import com.faz.news.model.NewsArticle
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    @WorkerThread
    fun fetchNews(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<List<NewsArticle>>
}