package com.example.data.service

import com.example.data.CoroutineResult
import com.example.data.api.NewsApi
import com.example.data.model.NewsResponse
import javax.inject.Inject

class NewsServiceImpl @Inject constructor(private val newsApi: NewsApi) : NewsService {
    override fun getNewsList(): CoroutineResult<List<NewsResponse>> {
        return try {
            val callResponse = newsApi.getNewsList()
            val response = callResponse.execute()
            var newsList = emptyList<NewsResponse>()
            if (response.isSuccessful) {
                response.body()?.let {
                    newsList = it
                }
            }
            CoroutineResult.Success(newsList)
        } catch (e: Exception) {
            CoroutineResult.Failure(java.lang.Exception())
        }
    }
}
