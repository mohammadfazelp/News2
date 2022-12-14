package com.faz.domain.usecase

import com.faz.domain.Configuration
import com.faz.domain.model.NewsArticle
import com.faz.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    configuration: Configuration,
    private val newsRepository: NewsRepository
) : UseCase<GetNewsUseCase.Request, GetNewsUseCase.Response>(configuration) {

    data class Request(val page: Int) : UseCase.Request

    data class Response(val news: List<NewsArticle>) : UseCase.Response

    override fun process(request: Request): Flow<Response> =
        newsRepository.fetchNews(page = request.page).map { Response(it)
        }
}