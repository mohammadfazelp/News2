package com.faz.data.di

import com.faz.data.local.datasource.NewsLocalDataSourceImpl
import com.faz.data.network.datasource.NewsRemoteDataSource
import com.faz.data.network.datasource.NewsRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {
    @Binds
    abstract fun bindNewsLocalDataSource(newsLocalDataSourceImpl: NewsLocalDataSourceImpl):
            NewsRemoteDataSource
}