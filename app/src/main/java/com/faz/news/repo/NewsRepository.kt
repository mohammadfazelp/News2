package com.faz.news.repo

import com.faz.news.model.NewsArticle

interface NewsRepository {
    fun fetchNews(): List<NewsArticle>
}