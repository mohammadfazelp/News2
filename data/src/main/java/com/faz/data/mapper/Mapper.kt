package com.faz.data.mapper

import com.faz.data.local.entity.NewsEntity
import com.faz.data.model.NewsArticleApi
import com.faz.data.model.NewsSourceApi
import com.faz.domain.model.NewsArticle
import com.faz.domain.model.NewsSource

fun NewsSourceApi.mapFromApiToPure() = NewsSource(id, name)

fun List<NewsArticleApi>.mapFromApiToPure(): List<NewsArticle> {
    val newsList = mutableListOf<NewsArticle>()
    forEach { news ->
        newsList.add(
            NewsArticle(
                publishedAt = news.publishedAt,
                author = news.author,
                source = news.source?.mapFromApiToPure(),
                title = news.title,
                description = news.description,
                url = news.url,
                urlToImage = news.urlToImage,
                content = news.content
            )
        )
    }
    return newsList
}

fun List<NewsArticle>.mapFromPureToEntity(): List<NewsEntity> {
    val newsList = mutableListOf<NewsEntity>()
    forEach {
        newsList.add(
            NewsEntity(
                it.publishedAt,
                it.author,
                it.title,
                it.description,
                it.url,
                it.urlToImage,
                it.content
            )
        )
    }
    return newsList
}

fun List<NewsEntity>.mapFromEntityToPure(): List<NewsArticle> {
    val newsList = mutableListOf<NewsArticle>()
    forEach {
        newsList.add(
            NewsArticle(
                it.publishedAt,
                it.author,
                null,
                it.title,
                it.description,
                it.url,
                it.urlToImage,
                it.content
            )
        )
    }
    return newsList
}
