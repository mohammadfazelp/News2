package com.faz.news.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faz.domain.model.NewsArticle
import com.faz.domain.usecase.GetNewsUseCase
import com.faz.news.ui.state.NewsConverter
import com.faz.news.ui.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val useCase: GetNewsUseCase,
    private val converter: NewsConverter
) : ViewModel() {

    private val _newsFlow = MutableStateFlow<UiState<List<NewsArticle>>>(UiState.Loading)

    val newsFlow: StateFlow<UiState<List<NewsArticle>>> = _newsFlow

    fun loadNews(page: Int) {
        viewModelScope.launch {
            useCase.execute(GetNewsUseCase.Request(page)).map {
                converter.convert(it)
            }.collect {
                _newsFlow.value = it
            }
        }
    }
}