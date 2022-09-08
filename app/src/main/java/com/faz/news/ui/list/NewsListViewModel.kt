package com.faz.news.ui.list

import androidx.annotation.MainThread
import androidx.lifecycle.ViewModel
import com.faz.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val newsRepository: com.faz.domain.repository.NewsRepository
) : ViewModel() {

    var isLoading = true // todo
    var toastMessage : String? = "Something!" // todo

    private val fetchingIndex: MutableStateFlow<Int> = MutableStateFlow(0)

    @OptIn(ExperimentalCoroutinesApi::class)
    private val newsListFlow = fetchingIndex.flatMapLatest { page ->
        newsRepository.fetchNews(
            page = page,
            onStart = { isLoading = true },
            onComplete = { isLoading = false },
            onError = { toastMessage = it }
        )
    }

    @MainThread
    fun fetchNextNewsList() {
        if (!isLoading) {
            fetchingIndex.value++
        }
    }
}