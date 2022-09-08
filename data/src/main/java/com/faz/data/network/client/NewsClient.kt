package com.faz.data.network.client

import com.faz.data.network.service.NewsService
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

class NewsClient @Inject constructor(
    private val service: NewsService
) {
    suspend fun fetchNewsList(
        page: Int
    ): ApiResponse<com.faz.data.model.NewsResponseApi> =
        service.fetchNewsList(
            limit = PAGING_SIZE,
            offset = page * PAGING_SIZE
        )

    companion object {
        private const val PAGING_SIZE = 20
    }
}
