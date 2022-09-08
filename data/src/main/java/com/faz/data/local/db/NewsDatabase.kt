package com.faz.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.faz.data.local.entity.NewsEntity
import com.faz.data.local.converter.TypeResponseConverter
import com.faz.data.local.dao.NewsDao

@Database(
    entities = [NewsEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(value = [TypeResponseConverter::class])
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}