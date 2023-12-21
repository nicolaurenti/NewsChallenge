package com.example.newschallenge.di

import com.example.domain.di.DomainModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DomainModule::class])
@InstallIn(SingletonComponent::class)
class AppModule
