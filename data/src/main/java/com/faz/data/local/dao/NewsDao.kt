package com.faz.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.faz.data.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(newsList: List<NewsEntity>)

    @Query("SELECT * FROM NewsEntity")
    fun getAllNews(page_: Int): Flow<List<NewsEntity>>
}
