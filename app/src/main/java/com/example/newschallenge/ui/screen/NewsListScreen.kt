package com.example.newschallenge.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.News
import com.example.newschallenge.ui.ErrorModal
import com.example.newschallenge.ui.LoadingIndicator
import com.example.newschallenge.ui.SearchComponent
import com.example.newschallenge.ui.TextStyles.headerFontStyle
import com.example.newschallenge.viewmodel.LatestNewsUiState
import com.example.newschallenge.viewmodel.NewsViewModel

@Composable
fun NewsListScreen(
    viewModel: NewsViewModel = hiltViewModel(),
    onClickItem: (news: News) -> Unit,
) {
    viewModel.getNewsList()
    val uiState by viewModel.uiState.collectAsState()
    when (uiState) {
        LatestNewsUiState.SHOW_LIST -> Content(
            news = viewModel.newsList.collectAsState().value,
            onClickItem = onClickItem,
        )
        LatestNewsUiState.LOADING -> LoadingIndicator()
        else -> { ErrorModal() }
    }
}

@Composable
fun Content(
    news: List<News>,
    onClickItem: (news: News) -> Unit,
) {
    Column(modifier = Modifier.padding(16.dp)) {
        SearchComponent()
        Text(
            text = "Latest news",
            style = headerFontStyle,
            modifier = Modifier.padding(vertical = 16.dp),
        )

        LazyColumn {
            items(news) { item ->
                NewsItem(news = item, onClickItem = onClickItem)
            }
        }
    }
}
