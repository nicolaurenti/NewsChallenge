package com.example.domain.mapper

import com.example.data.model.NewsResponse
import com.example.domain.News

class NewsMapper {
    fun transformNews(newsResponses: List<NewsResponse>): List<News> {
        val news = mutableListOf<News>()
        newsResponses.forEach { item ->
            news.add(
                News(
                    id = item.id,
                    userId = item.userId,
                    title = item.title,
                    content = item.body,
                    imageUrl = "https://picsum.photos/200",
                ),
            )
        }
        return news
    }
}
