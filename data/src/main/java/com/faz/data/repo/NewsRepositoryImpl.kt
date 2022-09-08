package com.faz.data.repo

import com.faz.data.local.datasource.NewsLocalDataSource
import com.faz.data.network.datasource.NewsRemoteDataSource
import com.faz.data.network.dispatcher.Dispatcher
import com.faz.data.network.dispatcher.NewsDispatchers
import com.faz.domain.model.NewsArticle
import com.faz.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onEmpty
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource,
    @Dispatcher(NewsDispatchers.IO) private val ioDispatcher: Dispatcher
) : NewsRepository {

//    @WorkerThread
//    override fun fetchNews(
//        page: Int,
//        onStart: () -> Unit,
//        onComplete: () -> Unit,
//        onError: (String?) -> Unit
//    ) = flow {
//        var news = newsDao.getNews(page)
//        if(news.isEmpty()){
//            val response = newsClient.fetchNewsList(page)
//            response.suspendOnSuccess {
//
//            }
//        }
//    }.onStart { onStart() }.onCompletion { onComplete }.flowOn(ioDispatcher)

    override fun fetchNews(page: Int): Flow<List<NewsArticle>> {
        val news = newsLocalDataSource.fetchNews(page)
        news.onEmpty {
            newsRemoteDataSource.fetchNews(page).onEach {
                newsLocalDataSource.insertNews(it)
            }
        }
        return newsLocalDataSource.fetchNews(page)
    }

    override fun fetchNewsItem(id: Long): Flow<NewsArticle> {
        TODO("Not yet implemented")
    }

    override fun saveNews(news: List<NewsArticle>) {
        TODO("Not yet implemented")
    }
}