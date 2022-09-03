package com.faz.news.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(newsList: List<NewsEntity>)

    @Query("SELECT * FROM NewsEntity WHERE page = :page_")
    suspend fun getNews(page_: Int): List<NewsEntity>

    @Query("SELECT * FROM NewsEntity WHERE page <= :page_")
    suspend fun getAllNews (page_: Int): List<NewsEntity>
}
