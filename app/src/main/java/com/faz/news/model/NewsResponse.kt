package com.faz.news.model

import com.squareup.moshi.Json

data class NewsResponse(
    @field:Json(name = "articles") val articles: List<NewsArticle>,
    @field:Json(name = "status") var status: String,
    @field:Json(name = "totalResults") val totalResults: Int
)