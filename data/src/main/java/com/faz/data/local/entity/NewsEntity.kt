package com.faz.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.faz.domain.model.NewsSource

@Entity
data class NewsEntity(
    @ColumnInfo(name = "publishedAt") val publishedAt: String? = null,
    @ColumnInfo(name = "author") val author: String? = null,
//    @ColumnInfo(name = "source") val source: NewsSource? = null, // todo : Converter
    @ColumnInfo(name = "title") val title: String? = null,
    @ColumnInfo(name = "description") val description: String? = null,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "url") val url: String? = null,
    @ColumnInfo(name = "urlToImage") val urlToImage: String? = null,
    @ColumnInfo(name = "content") val content: String? = null
)
