package com.example.data.api

import com.example.data.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface NewsApi {
    @GET("posts/")
    fun getNewsList(): Call<List<NewsResponse>>
}
