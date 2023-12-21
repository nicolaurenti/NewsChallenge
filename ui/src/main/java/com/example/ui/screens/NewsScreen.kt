package com.example.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ui.theme.NewsChallengeTheme
import com.example.ui.theme.TextStyles.headerFontStyle
import com.example.ui.theme.TextStyles.titleFontStyle
import com.example.ui.theme.softGray

@Composable
fun NewsScreen(newsList: List<News>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Latest news",
            style = headerFontStyle,
            modifier = Modifier.padding(vertical = 16.dp),
        )

        LazyColumn {
            items(newsList) { item ->
                NewsItem(news = item)
            }
        }
    }
}

@Composable
fun NewsItem(news: News) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
        ),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = SoftGray,
        ),
        modifier = Modifier.fillMaxWidth().height(130.dp).padding(vertical = 8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = news.imageUrl,
                contentDescription = "news image",
                modifier = Modifier.fillMaxHeight().weight(1f).clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = news.title,
                modifier = Modifier.weight(2f).padding(16.dp),
                style = titleFontStyle,
            )
        }
    }
}

@Preview
@Composable
fun NewsScreenPreview() {
    NewsScreen(
        listOf(
            News(
                id = 1,
                title = "unt aut facere repellat provident occaecati excepturi optio reprehenderit",
            ),
            News(
                id = 1,
                title = "unt aut facere repellat provident occaecati excepturi optio reprehenderit",
            ),
            News(
                id = 1,
                title = "unt aut facere repellat provident occaecati excepturi optio reprehenderit",
            ),
            News(
                id = 1,
                title = "unt aut facere repellat provident occaecati excepturi optio reprehenderit",
            ),
            News(
                id = 1,
                title = "unt aut facere repellat provident occaecati excepturi optio reprehenderit",
            ),
            News(
                id = 1,
                title = "unt aut facere repellat provident occaecati excepturi optio reprehenderit",
            ),
            News(
                id = 1,
                title = "unt aut facere repellat provident occaecati excepturi optio reprehenderit",
            ),
            News(
                id = 1,
                title = "unt aut facere repellat provident occaecati excepturi optio reprehenderit",
            )
        ),
    )
}
@Preview
@Composable
private fun NewsItemPreview() {
    NewsChallengeTheme {
        NewsItem(
            News(
                id = 1,
                title = "unt aut facere repellat provident occaecati excepturi optio reprehenderit",
            ),
        )
    }
}

data class News(
    val id: Int,
    val title: String,
    val imageUrl: String = "https://picsum.photos/200",
)
