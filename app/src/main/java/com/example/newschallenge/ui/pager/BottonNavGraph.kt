package com.example.newschallenge.ui.pager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.domain.News
import com.example.newschallenge.ui.screen.NewsListScreen
import com.example.newschallenge.ui.screen.UserScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomNavGraph(
    pagerState: PagerState,
    onClickItem: (news: News) -> Unit,
    onLocationCLick: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        HorizontalPager(
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> NewsListScreen(onClickItem = onClickItem)
                1 -> UserScreen(onLocationCLick = onLocationCLick)
                else -> NewsListScreen(onClickItem = onClickItem)
            }
        }
    }
}
