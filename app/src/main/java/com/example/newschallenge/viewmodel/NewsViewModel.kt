package com.example.newschallenge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.CoroutineResult
import com.example.domain.News
import com.example.domain.usecase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
) : ViewModel() {

    private var _newsList = MutableStateFlow<List<News>>(emptyList())
    val newsList: StateFlow<List<News>> = _newsList

    private var _uiState =
        MutableStateFlow(LatestNewsUiState.LOADING)
    val uiState: StateFlow<LatestNewsUiState> = _uiState

    fun getNewsList() =
        viewModelScope.launch {
            withContext(Dispatchers.IO) { getNewsUseCase() }.let { favoriteNews ->
                when (favoriteNews) {
                    is CoroutineResult.Success -> {
                        _uiState.value = LatestNewsUiState.SHOW_LIST
                        _newsList.value = favoriteNews.data
                    }

                    is CoroutineResult.Failure -> {
                        _uiState.value = LatestNewsUiState.ERROR
                    }
                }
            }
        }

    fun searchNews(query: String) {
        if (_uiState.value == LatestNewsUiState.SHOW_LIST) {
            val foundRecipes = _newsList.value.filter { item ->
                item.title.contains(query)
            }
            _newsList.value = foundRecipes
        } else {
            _newsList.value = emptyList()
        }
    }
}

enum class LatestNewsUiState {
    LOADING,
    SHOW_LIST,
    ERROR,
}
