package com.example.domain.di

import com.example.data.service.NewsService
import com.example.domain.usecase.GetNewsUseCase
import com.example.domain.usecase.GetNewsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetNewsListUseCase(newsService: NewsService): GetNewsUseCase =
        GetNewsUseCaseImpl(newsService)
}
