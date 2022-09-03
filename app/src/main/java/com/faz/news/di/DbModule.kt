package com.faz.news.di

import android.app.Application
import androidx.room.Room
import com.faz.news.data.database.NewsDao
import com.faz.news.data.database.NewsDatabase
import com.faz.news.data.database.TypeResponseConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application,
        typeResponseConverter: TypeResponseConverter
    ): NewsDatabase {
        return Room
            .databaseBuilder(application, NewsDatabase::class.java, "news.db")
            .fallbackToDestructiveMigration()
            .addTypeConverter(typeResponseConverter)
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(appDatabase: NewsDatabase): NewsDao {
        return appDatabase.newsDao()
    }

    @Provides
    @Singleton
    fun provideTypeResponseConverter(moshi: Moshi): TypeResponseConverter {
        return TypeResponseConverter(moshi)
    }
}
