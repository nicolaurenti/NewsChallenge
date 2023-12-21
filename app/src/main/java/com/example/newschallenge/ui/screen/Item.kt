package com.example.newschallenge.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.News
import com.example.newschallenge.ui.SoftGray
import com.example.newschallenge.ui.TextStyles.contentFontStyle

@Composable
fun NewsItem(
    news: News,
    onClickItem: (news: News) -> Unit,
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
        ),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = SoftGray,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(vertical = 8.dp)
            .clickable { onClickItem(news) },
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
                style = contentFontStyle,
            )
        }
    }
}
