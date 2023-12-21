package com.example.data.service

import com.example.data.CoroutineResult
import com.example.data.model.NewsResponse

interface NewsService {
    fun getNewsList(): CoroutineResult<List<NewsResponse>>
}
