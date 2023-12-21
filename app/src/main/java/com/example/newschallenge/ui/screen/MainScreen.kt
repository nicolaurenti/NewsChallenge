package com.example.newschallenge.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.domain.News
import com.example.newschallenge.ui.BottomBar
import com.example.newschallenge.ui.BottomBarScreen
import com.example.newschallenge.ui.pager.BottomNavGraph

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    onClickItem: (news: News) -> Unit,
    onLocationCLick: () -> Unit,
) {
    val screens = listOf(
        BottomBarScreen.News,
        BottomBarScreen.User,
    )
    val pagerState = rememberPagerState(pageCount = {
        screens.size
    })
    Scaffold(
        bottomBar = { BottomBar(pagerState = pagerState, screens = screens) },
    ) { innerPaddingValues ->
        Box(
            modifier = Modifier.padding(innerPaddingValues),
        ) {
            BottomNavGraph(
                pagerState = pagerState,
                onClickItem = onClickItem,
                onLocationCLick = onLocationCLick,
            )
        }
    }
}
