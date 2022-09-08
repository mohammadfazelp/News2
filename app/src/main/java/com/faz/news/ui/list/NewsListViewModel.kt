package com.faz.news.ui.list

import androidx.annotation.MainThread
import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faz.news.model.NewsArticle
import com.faz.news.repo.NewsRepository
import com.skydoves.bindables.asBindingProperty
import com.skydoves.bindables.bindingProperty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val newsRepository: NewsRepository
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