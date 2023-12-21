package com.example.newschallenge.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.News
import com.example.newschallenge.ui.TextStyles

@Composable
fun NewsDetailScreen(news: News) {
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 40.dp,
                bottomEnd = 40.dp,
            ),
        ) {
            AsyncImage(
                model = "https://picsum.photos/400",
                contentDescription = "news image",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = news.title,
            style = TextStyles.headerFontStyle,
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 12.dp),
        )
        Text(
            text = news.content,
            style = TextStyles.contentLightFontStyle,
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 12.dp),
        )
    }
}
