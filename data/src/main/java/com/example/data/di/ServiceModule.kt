package com.example.data.di

import com.example.data.api.NewsApi
import com.example.data.service.NewsService
import com.example.data.service.NewsServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    fun provideNewsService(newsApi: NewsApi): NewsService = NewsServiceImpl(newsApi)
}
