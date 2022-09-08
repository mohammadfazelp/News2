package com.faz.domain.model

data class NewsResponse(
    val articles: List<NewsArticle>,
    var status: String,
    val totalResults: Int
)