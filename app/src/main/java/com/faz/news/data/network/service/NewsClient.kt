package com.faz.news.data.network.service

import com.faz.news.model.NewsResponse
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

class NewsClient @Inject constructor(
    private val service: NewsService
) {
    suspend fun fetchNewsList(
        page: Int
    ): ApiResponse<NewsResponse> =
        service.fetchNewsList(
            limit = PAGING_SIZE,
            offset = page * PAGING_SIZE
        )

    companion object {
        private const val PAGING_SIZE = 20
    }
}
