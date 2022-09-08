package com.faz.data.di

import com.faz.data.network.datasource.NewsRemoteDataSource
import com.faz.data.network.datasource.NewsRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun bindNewsRemoteDataSource(nesRemoteDataSourceImpl: NewsRemoteDataSourceImpl):
            NewsRemoteDataSource
}