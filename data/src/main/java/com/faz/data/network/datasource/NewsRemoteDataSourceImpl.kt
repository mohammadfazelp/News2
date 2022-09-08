package com.faz.data.network.datasource

import com.faz.data.mapper.mapFromApiToPure
import com.faz.data.network.service.NewsService
import com.faz.domain.model.NewsArticle
import com.faz.domain.usecase.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class NewsRemoteDataSourceImpl(private val newsService: NewsService) : NewsRemoteDataSource {
    override fun fetchNews(page: Int): Flow<List<NewsArticle>> = flow {
        emit(newsService.fetchNewsList(page))
    }.map {
        it.articles.mapFromApiToPure()
    }.catch {
        throw UseCaseException.createFromThrowable(it)
    }
}