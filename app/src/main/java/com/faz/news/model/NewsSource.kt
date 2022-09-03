package com.faz.news.model

import com.squareup.moshi.Json

data class NewsSource(
    @field:Json(name = "id") val id: String? = null,
    @field:Json(name = "name") val name: String? = null
)