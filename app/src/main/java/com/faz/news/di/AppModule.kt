package com.faz.news.di

import com.faz.domain.Configuration
import com.faz.domain.usecase.UseCase
import dagger.Provides
import kotlinx.coroutines.Dispatchers

class AppModule {
    @Provides
    fun provideUseCaseConfiguration() = Configuration(Dispatchers.IO)
}