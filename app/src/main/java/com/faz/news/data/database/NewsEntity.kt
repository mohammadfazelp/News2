package com.faz.news.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewsEntity(
    var page: Int = 0,
    @PrimaryKey val name: String,
    val url: String
)
