package com.example.newschallenge.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomBar(
    pagerState: PagerState,
    screens: List<BottomBarScreen>,
) {
    Row(
        modifier = Modifier
            .height(60.dp)
            .background(Color.Black)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                pagerState = pagerState,
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AddItem(
    screen: BottomBarScreen,
    pagerState: PagerState,
) {
    val coroutineScope = rememberCoroutineScope()
    val selected = pagerState.currentPage == screen.page
    val background = if (selected) Color.Magenta else Color.Transparent

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(screen.page)
                    }
                },
            ),
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Icon(
                imageVector = screen.icon,
                contentDescription = screen.description,
                tint = Color.White,
            )
            Text(
                text = screen.title,
                color = Color.White,
            )
        }
    }
}

sealed class BottomBarScreen(
    val title: String,
    val icon: ImageVector,
    val description: String,
    val page: Int,
) {
    object News : BottomBarScreen(
        title = "News",
        icon = Icons.Default.List,
        description = "Home description",
        page = 0,
    )

    object User : BottomBarScreen(
        title = "User",
        icon = Icons.Default.LocationOn,
        description = "Profile description",
        page = 1,
    )
}
